package target.method;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD }) // 用于方法，包括注解类型的元素
public @interface MyAnnotation {

	String value() default "设置默认值";

}
