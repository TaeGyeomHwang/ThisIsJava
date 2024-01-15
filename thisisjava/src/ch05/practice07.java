package ch05;

public class practice07 {

	public static void main(String[] args) {
		int[] array = { 1, 5, 3, 8, 2 };
		int maxNum = 0;
		for(int num:array) {
			if(num>maxNum) {
				maxNum = num;
			}
		}
		System.out.println(maxNum);

	}

}
