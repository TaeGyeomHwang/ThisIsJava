package ch12;

import java.lang.reflect.*;

public class CarExam {

	public static void main(String[] args) {
//		Class c = Car.class;

//		Car car = new Car();
//		Class c1 = car.getClass();
		Class c2 = null;

		try {
			c2 = Class.forName("ch12.Car");
		} catch (ClassNotFoundException e) {
			System.out.println("해당 클래스가 존재하지 않습니다.");
		}

//		System.out.println(c2.getPackageName());
//		System.out.println(c2.getSimpleName());
//		System.out.println(c2.getName());

		Field[] fields = c2.getDeclaredFields();
		System.out.println("필드 수: " + fields.length);
		for (Field f : fields) {
			System.out.print(f.getType());
			System.out.println(" " + f.getName());
		}

		Constructor[] constructors = c2.getConstructors();
		System.out.println("생성자 수: " + constructors.length);
		for (Constructor c : constructors) {
			System.out.print(c.getName());
			Class[] types = c.getParameterTypes();
			for (Class t : types) {
				System.out.print(", " + t);
			}
			System.out.println();
		}

		Method[] methods = c2.getDeclaredMethods();
		System.out.println("메소드 수: " + methods.length);
		for (Method m : methods) {
			System.out.print(m.getName() + ", ");
		}
		System.out.println();

		try {
			Car car = new Car("현대자동차");
			Method getter = c2.getDeclaredMethod("getModel");
			System.out.println(getter.getName());
			System.out.println(getter.invoke(car));
			Method setter = c2.getDeclaredMethod("setModel", String.class); // String 파라미터를 클래스 타입으로 넘기기 위해
			setter.invoke(car, "기아자동차");
			System.out.println(getter.invoke(car));
		} catch (NoSuchMethodException | SecurityException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("해당 메소드가 존재하지 않습니다.");
		}
	}

}
