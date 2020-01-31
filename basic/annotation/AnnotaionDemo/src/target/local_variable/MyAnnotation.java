package target.local_variable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.LOCAL_VARIABLE }) // 用于局部变量声明
public @interface MyAnnotation {

	String value() default "设置默认值";

}
