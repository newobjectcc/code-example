package target.type_parameter;

// 用于类的类型声明
public class AnnotationUse<@MyAnnotation T> {

	private T t;

	public AnnotationUse(T t) {
		this.t = t;
	}

	// 用于方法类型声明
	public <@MyAnnotation K> K demo(K k) {
		// ...
		return k;
	}

	// ...

}

// 用于接口的类型声明
interface AnnotationUse1<@MyAnnotation T> {
	T demo();
}
