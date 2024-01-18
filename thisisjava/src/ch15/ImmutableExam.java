package ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableExam {

	public static void main(String[] args) {
		List<String> l1 = List.of("A", "B", "C");	//	immutable
		Set<String> s1 = Set.of("A", "B", "C");	//	immutable
		Map<Integer, String> m1 = Map.of(	//	immutable
				1, "A", 
				2, "B", 
				3, "C");
		
		List<String> l2 = new ArrayList<>();
		l2.add("A");
		l2.add("B");
		l2.add("C");
		List<String> l3 = List.copyOf(l2);	//	immutable

		String[] arr = {"A", "B", "C"};
		List<String> l4 = Arrays.asList(arr);	//	immutable
		
		List<String> l5 = new ArrayList<>();	//	mutable
		for(String s: arr) {
			l5.add(s);
		}
	}

}
