package target.method;

//用于方法
public class AnnotationUse {

	@MyAnnotation
	public void demo() {

	}

}

// //用于接口的方法
interface AnnotationUse2 {

	@MyAnnotation
	void demo();
}

// 用于注解类型的元素上
@interface AnnotationUse3 {

	@MyAnnotation
	String value();
}
