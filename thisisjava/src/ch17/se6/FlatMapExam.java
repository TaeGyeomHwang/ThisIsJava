package ch17.se6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapExam {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("this is java");
		list.add("i am a best developer");

		list.stream()
			.flatMap(data -> Arrays.stream(data.split(" ")))
			.forEach(e -> System.out.println(e));

		List<String> list2 = new ArrayList<>();
		list2.add("10, 20, 30");
		list2.add("40, 50");
		
		list2.stream()
			.flatMapToInt(data-> {
				String[] arr = data.split(", ");
				int[] intArr = new int[arr.length];
				
				for(int i=0; i<arr.length; i++) {
					intArr[i] = Integer.parseInt(arr[i]);
				}
				return Arrays.stream(intArr);
			})
			.forEach(e-> System.out.println(e));
	}

}
