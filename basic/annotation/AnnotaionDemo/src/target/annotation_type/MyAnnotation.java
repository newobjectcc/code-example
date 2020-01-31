package target.annotation_type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.ANNOTATION_TYPE }) // 仅用于注解
public @interface MyAnnotation {

	String value() default "设置默认值";

}
