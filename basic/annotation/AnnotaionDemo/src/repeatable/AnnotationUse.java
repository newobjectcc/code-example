package repeatable;

import java.lang.annotation.Annotation;

@MyAnnotation("A")
@MyAnnotation("B")
// 重复注解最后由编译器隐式地转换成了如下方式：
// @MyAnnotations({@MyAnnotation("A"), @MyAnnotation("B")})
public class AnnotationUse {

	public static void main(String[] args) throws Exception {

		Annotation[] annotations = AnnotationUse.class.getAnnotations();
		for (Annotation a : annotations) {
			System.out.println(a);
		}

		/**
		 * 反射相关类都实现了AnnotatedElement接口，来读取注解信息。
		 * 在1.8版本中该接口新增getAnnotationsByType()方法来返回与此元素关联的注解，
		 * 可以更方便的来获取重复注解。
		 * 
		 * https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/reflect/AnnotatedElement.html#getAnnotationsByType(java.lang.Class)
		 */
		MyAnnotation[] annotations2 = AnnotationUse.class.getAnnotationsByType(MyAnnotation.class);
		for (MyAnnotation a : annotations2) {
			System.out.println(a);
		}

	}

}
