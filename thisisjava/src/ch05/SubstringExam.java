package ch05;

public class SubstringExam {

	public static void main(String[] args) {
//		String subject = "자바 프로그래밍";
//		System.out.println(subject.substring(3));
//		System.out.println(subject.substring(0,2));
//		
//		System.out.println(subject.indexOf("프로그래밍"));
//		
//		if(subject.indexOf("프로그래밍")==-1) {
//			System.out.println("결과가 없습니다.");
//		}else {
//			System.out.println("결과가 있습니다.");
//		}
		
		String fruit = "사과 딸기 포도 귤";
		String[] fruitList = fruit.split(" ");
		System.out.println(fruit.length());
		for(int i =0; i<fruitList.length; i++) {
			System.out.println(fruitList[i]);
		}
	}

}
