package target.type_use;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE_USE,ElementType.METHOD }) // 用于使用类型，从Java8开始
public @interface MyAnnotation {

	String value() default "设置默认值";

}
