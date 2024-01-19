package ch17.se6;

import java.util.Arrays;

public class MappingExam2 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Arrays.stream(arr)
		.asDoubleStream()	//	stream 내부 요소 double 원시타입
		.boxed()	//	Double 래퍼 객체
		.forEach(e->System.out.println(e.getClass()));
		
	}

}
