package ch07;

public class ChildExam {

	public static void main(String[] args) {
//		Child child = new Child();
//		Parent parent = child;	//	자동 타입 변환 - 참조 타입만 parent로 바꿨다.
//		
//		parent.method1();
//		parent.method2();	//	child에서 오버라이딩한 메소드가 실행된다.
////		parent.method3();	//	non-visible 해진다. parent로 강제로 형변환 했기 때문
//		
//		Child child2 = (Child)parent;
//		child2.method3();	//	참조 타입을 다시 돌리면 visible해진다.
		
		Child child = new Child();
		Parent parent = new Parent();
		
		method(child);	//	child도 parent이기 때문에 parent를 타입으로 받는 메서드도 실행 가능.
		method(parent);
	}
	
	static void method(Parent p) {
		p.method2();
	}
}
