package ch15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExam {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("JSP");
		set.add("Java");
		set.add("Spring");
		
		System.out.println(set.size());

		
		Iterator<String> iterator = set.iterator();	//	또는 iterator 사용
		while(iterator.hasNext()) {
			String s = iterator.next();
			if(s.equals("JDBC")) {
				iterator.remove();
			}
		}
		
		for(String s: set) {	//	순서대로 접근해서 꺼내오기 불가능하므로 for each문 사용
			System.out.println(s);
		}
	}

}
