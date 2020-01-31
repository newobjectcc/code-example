package inherited;

import java.lang.annotation.Annotation;

/**
 * 经过@Inherited修饰的注解用在某个类上后，这个注解会被这个类的子类继承
 * 
 * 但接口的实现类不能继承接口上@Inherited修饰的注解，以及类的方法并不从它所重载的方法继承注解
 * （如果是继承父类中的方法，方法上的注解不管是否用@Inherited修饰的，注解随着方法一起被继承下来的）
 */

//验证  @Inherited 元注解
public class AnnotationDemo {

	public static void main(String[] args) throws Exception {

		Annotation[] annotations = ChildClass.class.getAnnotations();
		for (Annotation a : annotations) {
			System.out.println("annotations:" + a);
		}

		// demo 继承的的方法
		Annotation[] annotations2 = ChildClass.class.getMethod("demo").getAnnotations();
		for (Annotation a : annotations2) {
			System.out.println("annotations2:" + a);
		}

		// demo2 为被覆盖的方法
		Annotation[] annotations3 = ChildClass.class.getMethod("demo2").getAnnotations();
		for (Annotation a : annotations3) {
			System.out.println("annotations3:" + a);
		}

		// 类多层继承
		Annotation[] annotations5 = ChildSubclass.class.getAnnotations();
		for (Annotation a : annotations5) {
			System.out.println("annotations5:" + a);
		}

		// ////////////////////

		Annotation[] annotations4 = ChildImpl.class.getAnnotations();
		for (Annotation a : annotations4) {
			System.out.println("annotations4:" + a);
		}

	}

}
