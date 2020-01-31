package reflect;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.TypeVariable;

@MyAnnotation("类AnnotationUse上注解")
public class AnnotationParse<@MyAnnotation("类型声明") T> {

	@MyAnnotation("域")
	public String name;

	@MyAnnotation("构造方法")
	public AnnotationParse(@MyAnnotation("构造方法形参") T t) {

	}

	@MyAnnotation("方法demo")
	public String demo(@MyAnnotation("方法demo的形参") String name) throws @MyAnnotation("方法demo的异常声明") Exception {

		/**
		 * 该局部变量注解在运行时是不保留在class文件中（或在运行时），因此运行时不能得到该注解信息
		 * 
		 * 参见：
		 * https://docs.oracle.com/javase/specs/jls/se13/html/jls-9.html#jls-9.6.4.2
		 * https://stackoverflow.com/questions/17237813/elementtype-local-variable-annotation-type
		 */
		@MyAnnotation("方法demo局域变量")
		String upper = name.toUpperCase();

		return upper;
	};

	public @MyAnnotation("获取demo2返回类型注解") String demo2(String name) {

		return "demo2";
	};

	public static void main(String[] args) throws Exception {

		// System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

		Class<?> clazz = AnnotationParse.class;

		// 获取类注解
		MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
		System.out.println(annotation.value());
		System.out.println(annotation.getClass().getName());

		// 获取类型声明注解
		TypeVariable<?>[] typeVariable = AnnotationParse.class.getTypeParameters();
		for (TypeVariable<?> tv : typeVariable) {
			System.out.println(tv.getAnnotation(MyAnnotation.class).value());
		}

		// 获取域注解
		annotation = clazz.getField("name").getAnnotation(MyAnnotation.class);
		System.out.println(annotation.value());

		// 获取构造方法注解
		annotation = clazz.getConstructor(Object.class).getAnnotation(MyAnnotation.class);
		System.out.println(annotation.value());

		// 获取形参注解
		AnnotatedType[] annotatedTypes = clazz.getConstructor(Object.class).getAnnotatedParameterTypes();
		for (AnnotatedType at : annotatedTypes) {
			System.out.println(at.getAnnotation(MyAnnotation.class).value());
		}

		// 获取方法注解
		annotation = clazz.getMethod("demo", String.class).getAnnotation(MyAnnotation.class);
		System.out.println(annotation.value());

		// 方法异常类型注解
		annotatedTypes = clazz.getMethod("demo", String.class).getAnnotatedExceptionTypes();
		for (AnnotatedType at : annotatedTypes) {
			System.out.println(at.getAnnotation(MyAnnotation.class).value());
		}

		// 获取注解上的注解信息
		Annotation[] annotations = clazz.getAnnotation(MyAnnotation.class).annotationType().getAnnotations();
		for (Annotation a : annotations) {
			//	System.out.println(a);
			if (a instanceof Retention) {
				Retention retention = (Retention) a;
				System.out.println(retention.value());
			}
		}

		// 获取重复注解列表

	}

}
