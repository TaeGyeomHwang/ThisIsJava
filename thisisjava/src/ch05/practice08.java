package ch05;

public class practice08 {

	public static void main(String[] args) {
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		int sumTotal = 0;
		int count = 0;
		
		for(int [] e: array) {
			for(int f:e) {
				sumTotal += f;
				count++;
			}
		}
		System.out.println(sumTotal);
		System.out.println(sumTotal/count);
	}

}
