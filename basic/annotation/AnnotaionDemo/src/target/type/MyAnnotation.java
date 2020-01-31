package target.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE }) // 用于类, 接口 ,注解, 枚举类型
public @interface MyAnnotation {

	String value() default "设置默认值";

}
