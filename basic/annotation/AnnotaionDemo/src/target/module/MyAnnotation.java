package target.module;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.MODULE }) // 用于模块
public @interface MyAnnotation {

	String value() default "设置默认值";

}
