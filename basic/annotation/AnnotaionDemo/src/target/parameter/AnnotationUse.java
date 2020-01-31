package target.parameter;

//用于形参
public class AnnotationUse {

	AnnotationUse(@MyAnnotation String name) {

	}

	public void demo(@MyAnnotation String name) throws Exception {
		// ...
	}

}
