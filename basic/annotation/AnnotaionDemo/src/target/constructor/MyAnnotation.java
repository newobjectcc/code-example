package target.constructor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.CONSTRUCTOR }) // 用于构造方法
public @interface MyAnnotation {

	String value() default "设置默认值";

}
