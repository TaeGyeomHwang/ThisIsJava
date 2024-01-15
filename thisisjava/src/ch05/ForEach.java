package ch05;

public class ForEach {

	public static void main(String[] args) {
		String[] strArr= {"자바", "파이썬", "리액트", "AWS"};
		
		//	인덱스를 활용할 필요가 없을 경우 사용 가능
		for(String str : strArr) {
			System.out.println(str);
		}

	}

}
