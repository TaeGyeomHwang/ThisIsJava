package ch15;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExam {

	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<>();

		scores.add(80);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(32);
		scores.add(78);

		for (Integer i : scores) {
			System.out.print(i + ", ");
		}
		System.out.println();

		System.out.println(scores.first()); // 가장 작은
		System.out.println(scores.last()); // 가장 큰
		System.out.println(scores.lower(95)); // 미만 중 첫번째
		System.out.println(scores.higher(95)); // 초과 중 첫번째
		System.out.println(scores.floor(95)); // 이하 중 첫번째
		System.out.println(scores.ceiling(80)); // 이상 중 첫번째

//		System.out.println(scores.pollFirst());	//	첫번째를 꺼내옴
//		System.out.println(scores.pollLast());
//		for (Integer i : scores) {
//			System.out.print(i + ", ");
//		}

//		Iterator<Integer> iterator = scores.descendingIterator();	//	이터레이터는 잘 안쓴다.
//		while(iterator.hasNext()) {
//			System.out.print(iterator.next() + ", ");
//		}
//		System.out.println();

		for (Integer i : scores.descendingSet()) { // 보통 이렇게 사용.
			System.out.print(i + ", ");
		}
		System.out.println();

		for (Integer i : scores.headSet(75, true)) { // 이하 모든 값 (디폴트: false)
			System.out.print(i + ", ");
		}
		System.out.println();

		for (Integer i : scores.tailSet(75, true)) { // 이상 모든 값 (디폴트: false)
			System.out.print(i + ", ");
		}
		System.out.println();

		for (Integer i : scores.subSet(78, true, 98, true)) { // 사잇값 (시작-디폴트: true)
			System.out.print(i + ", ");
		}
		System.out.println();
	}

}
