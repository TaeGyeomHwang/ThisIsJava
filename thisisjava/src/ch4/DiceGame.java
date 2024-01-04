package ch4;

import java.util.*;

public class DiceGame {

	public static void main(String[] args) {
		int prize = 0;
		int maxDice = 0;
		Scanner scan = new Scanner(System.in);

		System.out.printf("첫 번째 주사위를 굴리시겠습니까? -> ");
		scan.nextLine();
		int dice1 = (int) (Math.random() * 6) + 1; // Math.random에 괄호를 붙이지 않으면 int로 형 변환시 0이 반환된다.
		System.out.println("첫 번째 주사위 값 : [" + dice1 + "]");

		System.out.printf("두 번째 주사위를 굴리시겠습니까? -> ");
		scan.nextLine();
		int dice2 = (int) Math.random() * 6 + 1;
		System.out.println("두 번째 주사위 값 : [" + dice2 + "]");

		System.out.printf("세 번째 주사위를 굴리시겠습니까? -> ");
		scan.nextLine();
		int dice3 = (int) Math.random() * 6 + 1;
		System.out.println("세 번째 주사위 값 : [" + dice3 + "]");

		if (dice1 == dice2 && dice2 == dice3 && dice1 == dice3) {
			prize = 10000 + dice1 * 1000;
		} else if (dice1 != dice2 && dice2 != dice3 && dice1 != dice3) {
			prize = (Math.max(dice1, (Math.max(dice2, dice3)) * 100));
		} else {
			if (dice1 == dice2) {
				maxDice = dice1;
			} else if (dice2 == dice3) {
				maxDice = dice2;
			} else {
				maxDice = dice1;
			}
			prize = 1000 + maxDice * 100;
		}

		System.out.printf("총 상금은 [" + prize + "] 입니다.");
	}

}
