package repeatable;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 容器@MyAnnotationContainer的生命周期至少要大于等于@MyAnnotation
 * 
 * 如果@MyAnnotation为可继承的，那么容器@MyAnnotationContainer也得声明为可继承的。
 * 反之，注解容器声明为可继承的，并不要求注解声明为可继承的。
 * 
 * 如果@MyAnnotation上没有@Target元注解且容器@MyAnnotationContainer也没有@Target元注解，则@MyAnnotation可以用任何支持该注解的元素上。
 * 如果@MyAnnotation上没有@Target元注解，但容器@MyAnnotationContainer有@Target元注解，则@MyAnnotation只能在容器@MyAnnotationContainer支持的元素上使用。
 * 如果@MyAnnotation上有@Target元注解，那么容器@MyAnnotationContainer上的@Target值必须与注解上的@Target种类值相同或为他的子集,但@MyAnnotation只能在容器@MyAnnotationContainer支持的元素上使用。
 */

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyAnnotations.class)
//@Target({ElementType.TYPE})
//@Inherited
public @interface MyAnnotation {

	String value() default "设置默认值";

}
