package ch12;

import java.util.Random;

public class RandomExam {

	public static void main(String[] args) {
//		Random rand = new Random(System.currentTimeMillis());	//	현재 시간을 이용해서 난수 생성
//		System.out.println(rand.nextInt());
		Random rand = new Random();
		System.out.println(rand.nextInt(6));
	}

}
