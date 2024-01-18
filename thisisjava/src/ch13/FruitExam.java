package ch13;

public class FruitExam {

	public static void main(String[] args) {
		Fruits<Apple<Integer>> f1 = new Fruits<>();
		f1.set(new Apple<Integer>(111));
		
		Fruits<Banana> f2 = new Fruits<>();
		f2.set(new Banana());
		
		Apple<Integer> apple = f1.get();	//	제네릭 없이 Object로 선언했다면 부모 타입을 자식에게 넣으려면 강제 형변환 필요
//		Banana banana = f1.get();	//	이미 위에서 제네릭 타입으로 Banana를 설정했으므로 Apple 타입을 넣을 수 없다.
		Integer appleName = apple.name;
		System.out.println(appleName);
		
		System.out.println(Fruits.<String, Integer>method1("사과!", 5));
		
		Fruits<String> f3 = new Fruits<>();
		System.out.println(f3.method2("hello"));
		System.out.println(f3.method2(10));
	}

}
