package ch05;

public class ArrayExam {

	public static void main(String[] args) {
		int[] heights = new int[5]; //	배열을 선언할 때는 사이즈를 꼭 명시해줘야 한다.
		heights[0] = 170;
		heights[1] = 174;
		heights[2] = 176;
		heights[3] = 179;
		heights[4] = 185;
		
		//	얕은 복사 - 동일한 배열을 참조
//		int[] heights2 = heights;
//		heights2[0] = 190;	//	배열의 경우 string과 다르게 참조하는 위치의 값을 변경할 수 있다.
							
		//	깊은복사
//		int[] heights2 = new int[heights.length];
//		for(int i=0; i<heights.length; i++) {
//			heights2[i] = heights[i];
//		}
		
		//	깊은복사 2
		int[] heights2 = new int[heights.length];;	//	빈 배열 생성
		System.arraycopy(heights, 0, heights2, 0, 5);	//	System.arrcopy 메서드 사용해서 복사
		
		for (int i = 0; i < heights.length; i++) {
			System.out.println(heights[i]);
		}
		System.out.println();
		for (int i = 0; i < heights2.length; i++) {
			System.out.println(heights2[i]);
		}
	}

}
