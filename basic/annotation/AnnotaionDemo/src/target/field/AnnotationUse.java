package target.field;

//用于域变量上
public class AnnotationUse {
	@MyAnnotation
	private static final String TYPE = "1";

	@MyAnnotation
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

// 用域枚举常量
enum AnnotationUse2 {
	@MyAnnotation ENUM1, @MyAnnotation ENUM2;
}
