package target.local_variable;

import java.io.BufferedReader;
import java.io.FileReader;

//用于局域变量
public class AnnotationUse {

	public void demo() {

		@MyAnnotation
		String name = "张三";

		for (@MyAnnotation
		int i = 0; i < 100; i++) {

			@MyAnnotation
			int j = i * 2;

			// ...
		}

		try (@MyAnnotation BufferedReader br = new BufferedReader(new FileReader("xxx.txt"))) {
			// ...

		} catch (@MyAnnotation Exception e) {
			// handle exception
		}

	}

}
