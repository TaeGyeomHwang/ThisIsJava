package ch3;

public class InfinityExam {

	public static void main(String[] args) {
		int a = 5;
		double b = 0.0;
		
		if(Double.isInfinite(a/b)) {
			System.out.println("a/b의 결과는 Infinity 입니다.");
		}
		if(Double.isNaN(a%b)) {
			System.out.println("a/b의 결과는 NaN 입니다.");
		}
	}

}
