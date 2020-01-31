package target.type;

// 用于类
@MyAnnotation
public class AnnotationUse {

	//	@MyAnnotation // 该注解上的元注解@Target值为 ElementType.TYPE因此该注解只能用于类,接口,注解,枚举类型上
	public void demo() {
	}

}

// 用于接口
@MyAnnotation
interface AnnotationUse1 {

}

// 用于枚举
@MyAnnotation
enum AnnotationUse2 {

}

// 用于注解
@MyAnnotation
@interface AnnotationUse3 {

}
