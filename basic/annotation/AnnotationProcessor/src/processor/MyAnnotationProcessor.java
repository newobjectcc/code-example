package processor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

import annotation.MyAnnotation;

@SupportedSourceVersion(SourceVersion.RELEASE_11)
@SupportedAnnotationTypes({ "annotation.MyAnnotation" })
public class MyAnnotationProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		try {
			for (Element element : roundEnv.getElementsAnnotatedWith(MyAnnotation.class)) {
				ElementKind kind = element.getKind();
				if (kind == ElementKind.CLASS || kind == ElementKind.INTERFACE) {
					List<? extends Element> elements = element.getEnclosedElements();
					for (Element ele : elements) {
						if (ele.getKind() == ElementKind.METHOD) {
							String nethodName = ele.getSimpleName().toString();
							if (Character.isUpperCase(nethodName.charAt(0)) || nethodName.contains("_")) {
								processingEnv.getMessager().printMessage(Kind.WARNING,
										"方法名\"" + nethodName + "\"首字母请小写且不要包含\"_\"", ele);
							}

						}
					}
				}
			}
		} catch (Throwable e) {
			exceptionWriter(e);
		}

		return false;
	}

	/**
	 * 将异常输出到文件
	 * 
	 * @param t
	 */
	private void exceptionWriter(Throwable t) {
		File f = new File("C:\\my-processor-log2.txt");
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			PrintWriter p = new PrintWriter(new FileWriter(f, true));
			t.printStackTrace(p);
			p.println("===========================\n");
			p.flush();
			p.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
