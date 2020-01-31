package target.type_parameter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE_PARAMETER }) // 用于类型参数声明，从Java8开始
public @interface MyAnnotation {

	String value() default "设置默认值";

}
