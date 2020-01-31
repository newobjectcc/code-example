package repeatable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.TYPE})
//@Inherited
public @interface MyAnnotations {

	MyAnnotation[] value();

}
