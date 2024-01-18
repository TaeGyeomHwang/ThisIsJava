package ch15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExam {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();	//	내부에서 형변환이 이뤄질 수 있게 list로 선언

		long startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			list1.add(0, String.valueOf(i));
		}
		System.out.println("ArrayList 걸린 시간: " + (double) (System.nanoTime() - startTime) / 1000000000 + "초");

		list1 = new LinkedList<>();
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			list1.add(0, String.valueOf(i));
		}
		System.out.println("LinkedList 걸린 시간: " + (double) (System.nanoTime() - startTime) / 1000000000 + "초");

	}

}
