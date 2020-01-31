package retention;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotation2 {

	String value() default "设置默认值";

}
