package ch05;

public class NthArray {

	public static void main(String[] args) {
//		int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//		System.out.println(array[0][0]);
		
		int[][] heights = new int[3][3];
		
		//	1반 학생들의 키
		heights[0][0] = 160; 
		heights[0][1] = 165; 
		heights[0][2] = 170; 
		
		//	2반 학생들의 키
		for(int i=0; i<heights[1].length; i++) {
			heights[1][i] = 170;
		}
		//	3반 학생들의 키
		for(int i=0; i<heights[2].length; i++) {
			heights[2][i] = 180;
		}
		
		//	각 반 학생들의 키 출력
		for(int i=0; i<heights.length; i++) {
			System.out.printf("%d반: ", i+1);
			for(int j=0; j<heights[i].length; j++) {
				if(j==heights[i].length-1) {
					System.out.println(heights[i][j]);
				}else {
					System.out.print(heights[i][j]+", ");
				}
			}
		}
	}

}
