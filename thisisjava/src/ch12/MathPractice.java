package ch12;

public class MathPractice {

	public static void main(String[] args) {
		int[] arr = { -123, -56, -32, -256, -4, -96 };

		System.out.println("두 점 사이의 거리는 " + distance(3, 6, 1, 2));
		System.out.println("최댓값은 " + maxVal1(arr));
		System.out.println("최댓값은 " + maxVal2(arr));
	}

	public static double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	public static int maxVal1(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}
	
	public static int maxVal2(int[] arr) {
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.min(Math.abs(arr[i]), max);
		}
		return -max;
	}

}
