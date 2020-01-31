package target.packag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.PACKAGE }) // 用于包声明
public @interface MyAnnotation {

	String value() default "设置默认值";

}
