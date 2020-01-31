package target.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD }) // 用于域, 包括枚举常量
public @interface MyAnnotation {

	String value() default "设置默认值";

}
