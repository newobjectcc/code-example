package retention;

import java.lang.annotation.Annotation;

/**
 * @Retention 元注解用来声明注解的生命周期(注解保留到哪个阶段)，分为三种：
 * RetentionPolicy.SOURCE：注解只会在源码中，编译时类上的注解会被编译器丢弃
 * RetentionPolicy.CLASS：编译器把注解记录在class文件中，但是在运行时不需要由VM保留。如不指定@Retention时，值默认为CLASS
 * RetentionPolicy.RUNTIME：编译器把注解记录在class文件中，并在运行时VM会保留，因此可以通过Java反射来读取注解信息。
 * 
 * 生命周期长短顺序为 SOURCE < CLASS < RUNTIME
 */

@MyAnnotation("生命周期是 RUNTIME")
@MyAnnotation2("声明周期是 SOURCE")
public class AnnotationUse {

	public static void main(String[] args) throws Exception {

		// 使用反射读取AnnotationUse上注解
		Annotation[] annotations = AnnotationUse.class.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}

		/**
		 *  @MyAnnotation2 的生命周期是 SOURCE, 运行时获取不到该注解信息。
		 *  
		 *  输出结果： 
		 *  @retention.MyAnnotation(value=生命周期是 RUNTIME)
		 */

	}

}
