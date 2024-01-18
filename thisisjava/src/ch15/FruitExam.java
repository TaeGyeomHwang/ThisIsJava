package ch15;

import java.util.Comparator;
import java.util.TreeSet;

public class FruitExam {

	public static void main(String[] args) {
//		TreeSet<Fruit> ts = new TreeSet<>(new FruitComparator());
//		TreeSet<Fruit> ts = new TreeSet<>(new Comparator<Fruit>() {	//	익명 객체로 구현 가능
//			@Override
//			public int compare(Fruit o1, Fruit o2) {
//				return o2.price - o1.price;
//			}
//		});
		TreeSet<Fruit> ts = new TreeSet<>((o1, o2) -> o1.price - o2.price);	//	람다식으로도 구현 가능

		ts.add(new Fruit("포도", 3000));
		ts.add(new Fruit("수박", 10000));
		ts.add(new Fruit("딸기", 6000));

		for (Fruit f : ts) {
			System.out.println(f.name + ", " + f.price);
		}
	}

}
