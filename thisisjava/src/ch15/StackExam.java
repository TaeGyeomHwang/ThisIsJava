package ch15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackExam {

	public static void main(String[] args) {
		Stack<Coin> st = new Stack<>();

		st.push(new Coin(100));
		st.push(new Coin(50));
		st.push(new Coin(500));
		st.push(new Coin(10));
		st.peek();

		while (!st.isEmpty()) {
			Coin coin = st.pop();
			System.out.println(coin.getValue());
		}

		Queue<Coin> q = new LinkedList<>();
		q.offer(new Coin(100));
		q.offer(new Coin(50));
		q.offer(new Coin(500));
		q.offer(new Coin(10));
		q.peek();
		System.out.println();

		while (!q.isEmpty()) {
			Coin coin = q.poll();
			System.out.println(coin.getValue());
		}
	}

}
