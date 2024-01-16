package ch12;

import java.util.StringTokenizer;

public class StringTokenaizerExam {

	public static void main(String[] args) {
		String str = "홍길동 26 남성";
		String[] str_arr = str.split(" ");

		String name = str_arr[0];
		String age = str_arr[1];
		String gender = str_arr[2];

		System.out.println(name);
		System.out.println(age);
		System.out.println(gender);

		System.out.println();

		StringTokenizer st = new StringTokenizer(str, " ");
		while (st.hasMoreTokens()) { // 토큰이 남아있는지 확인
			System.out.println("남은 토큰의 수: " + st.countTokens());
			System.out.println(st.nextToken());
		}

//		int count = st.countTokens();	//	꺼낼 때 마다 토큰이 몇개 남아있는지 확인하려면 사용
//		for(int i=0; i<count; i++) {
//			System.out.println(st.nextToken());
//		}
	}

}
