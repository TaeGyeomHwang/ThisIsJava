//package ch07;
//
//class A {}
//class B extends A{}
//class C extends A{}
//class D extends B{}
//class E extends C{}
//
//public class PromotionExam {
//	public static void main(String[] args) {
//		B b = new B();
//		C c = new C();
//		D d = new D();
//		E e = new E();
//		
//		A ab = b;
//		A ac = c;
//		A ad = d;
//		A ae = e;
//		
//		B bd = d;
//		C ce = e;
//		
//		B be = e;	//	상속 관계에 있지 않으므로 컴파일 에러 발생
//	}
//}
