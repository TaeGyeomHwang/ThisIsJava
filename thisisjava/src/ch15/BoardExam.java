package ch15;

import java.util.ArrayList;
import java.util.List;

public class BoardExam {

	public static void main(String[] args) {
		List<Board> list = new ArrayList<>();

		list.add(new Board("제목 1", "내용 1", "글쓴이 1"));
		list.add(new Board("제목 2", "내용 2", "글쓴이 2"));
		list.add(new Board("제목 3", "내용 3", "글쓴이 3"));
		list.add(new Board("제목 4", "내용 4", "글쓴이 4"));
		list.add(new Board("제목 5", "내용 5", "글쓴이 5"));

		int size = list.size();
		System.out.println("총 글 수: " + size);

//		for (int i = 0; i < size; i++) {
//			System.out.println("요소 " + i + "번: " + list.get(i));
//		}
		for(Board b: list) {	//	toString override가능
			System.out.println(b.toString());
		}
	}

}
