package inherited;

@MyAnnotation("可继承的 - ParentClass")
@MyAnnotation2("不可继承的 - ParentClass")
public class ParentClass {

	@MyAnnotation("可继承的 - demo")
	@MyAnnotation2("不可继承的 - demo")
	public void demo() {
	}
	
	
	@MyAnnotation("可继承的 - demo2")
	@MyAnnotation2("不可继承的 - demo2")
	public void demo2(){
		
	}
}
