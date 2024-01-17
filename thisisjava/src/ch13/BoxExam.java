package ch13;

public class BoxExam {

	public static <T extends Number> Box<T> boxing(T t){
		Box<T> box = new Box<T>();
		box.set(t);
		return box;
	}
	
	public static void main(String[] args) {
//		Box<Integer, String> box1 = new Box<>();
//		Box<String, Boolean> box2 = new Box<>();
//
//		box1.content1 = 100;
//		box1.content2 = "1oo";
//		box2.content1 = "string";
//		box2.content2 = true;
//
//		System.out.println(box1.content1 + box1.content2);
		
		Box<Integer> box1 = boxing(100);
		int intValue = box1.get();
		System.out.println(intValue);
		
//		Box<String> box2 = boxing("hello");	//	String은 Number를 상속하지 않으므로 사용 불가.
//		String strValue = box2.get();
//		System.out.println(strValue);
		
		Box<Double> box3 = boxing(10.2);
		double doubleValue = box3.get();
		System.out.println(doubleValue);
	}

}
