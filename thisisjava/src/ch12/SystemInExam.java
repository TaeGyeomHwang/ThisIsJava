package ch12;

import java.io.IOException;

public class SystemInExam {

	public static void main(String[] args) {
		int input = 0;
		int speed = 0;

		while (true) {
				System.out.println("---------------------------");
				System.out.println("1. 증속 | 2. 감속 | 3. 중지");
				System.out.println("---------------------------");
				System.out.println("현재 속도 = " + speed);
				System.out.printf("선택: ");
			
			try {
				input = System.in.read();
				System.in.read();
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (input == 49) {
				speed++;
			} else if (input == 50) {
				speed--;
			} else if (input == 51) {
				System.out.println("프로그램 종료");
				break;
			}
		}

	}

}
