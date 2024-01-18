package ch15;

import java.util.ArrayList;

public class ArrayListExam1 {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.add(40);
		arr.add(50);
		arr.add(3, 35);
		arr.set(3, 36);
//		arr.clear();
		
//		System.out.println(arr.contains(40));
//		System.out.println(arr.isEmpty());
//		System.out.println(arr.size());
		
		System.out.println(arr.remove(new Integer(36)));

		for (int i : arr) {
			System.out.println(i);
		}
//		System.out.println(arr.get(2));
	}

}
