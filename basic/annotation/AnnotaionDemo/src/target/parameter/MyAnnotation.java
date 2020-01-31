package target.parameter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.PARAMETER }) // 用于形参声明
public @interface MyAnnotation {

	String value() default "设置默认值";

}
