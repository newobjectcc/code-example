package target.type_use;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.List;

/**
 * TYPE_USE用于标注任意使用类型(TYPE_USE 可以用到任何使用到类型的地方，而TYPE_PARAMETER只能用于类型参数声明)
 * 如，多数声明或表达式中的类型
 * 
 * 更多请参考：
 * https://docs.oracle.com/javase/specs/jls/se12/html/jls-4.html#jls-4.11
 */

public class AnnotationUse<@MyAnnotation T> extends @MyAnnotation ArrayList<@MyAnnotation String> {

	private static final @MyAnnotation long serialVersionUID = 1L;

	private @MyAnnotation T t;

	private @MyAnnotation Class<@MyAnnotation ?> clazz;

	@MyAnnotation
	private int[] arr;

	private @MyAnnotation int i;

	@MyAnnotation
	public AnnotationUse(@MyAnnotation T t) {
		this.t = t;
	}

	@MyAnnotation("方法上的返回类型")
	public <K> @MyAnnotation("K") K demo(K k) throws @MyAnnotation("Exception") Exception {

		List<String> list = new @MyAnnotation ArrayList<String>();

		ArrayList<String> a = (@MyAnnotation ArrayList<String>) list;

		if (list instanceof @MyAnnotation ArrayList) {
		}

		return k;
	}

	// ...

	public static void main(String[] args) throws Exception {

		// https://segmentfault.com/q/1010000011015262/
		// System.err.println(AnnotationUse.class.getMethod("demo",Object.class).invoke(new AnnotationUse<String>("111"), 333));

		Annotation[] as = AnnotationUse.class.getMethod("demo", Object.class).getAnnotations();
		for (Annotation a : as) {
			System.err.println(a);
		}

		AnnotatedType[] as1 = AnnotationUse.class.getMethod("demo", Object.class).getAnnotatedExceptionTypes();
		for (AnnotatedType a : as1) {
			for (Annotation aa : a.getAnnotations()) {
				System.err.println(aa);
			}
		}

		AnnotatedType at = AnnotationUse.class.getMethod("demo", Object.class).getAnnotatedReturnType();
		for (Annotation aa : at.getAnnotations()) {
			System.err.println(aa);
		}

	}

}

// 用于接口的类型声明
interface AnnotationUse1<@MyAnnotation T> {
	@MyAnnotation
	T demo();
}

@interface AnnotationUse2 {
	@MyAnnotation
	String value();
}
