package ch06.practice;

import java.util.*;

public class BankApplication {

	public static void main(String[] args) {
		Account[] accountArr = new Account[100];
		int input = 0;
		String accountNum;
		String name;
		int balance;
		int money;

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("--------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("--------------------------------------------------");
			System.out.printf("선택> ");
			input = Integer.parseInt(scan.nextLine());

			if (input == 1) {
				System.out.println("--------");
				System.out.println("계좌생성");
				System.out.println("--------");

				System.out.printf("계좌번호: ");
				accountNum = scan.nextLine();
				System.out.printf("계좌주: ");
				name = scan.nextLine();
				System.out.printf("초기입금액: ");
				money = Integer.parseInt(scan.nextLine());

				Account myAccount = new Account(accountNum, name, money);
				for (int i = 0; i < accountArr.length; i++) {
					if (accountArr[i] == null) {
						accountArr[i] = myAccount;
						System.out.println("결과: 계좌가 개설되었습니다.");
						break;
					}
				}

			} else if (input == 2) {
				System.out.println("--------");
				System.out.println("계좌목록");
				System.out.println("--------");

				for (int i = 0; i < accountArr.length; i++) {
					if (accountArr[i] != null) {
						System.out.println(
								accountArr[i].getAccountNum() + "   " + accountArr[i].getName() + "   " + accountArr[i].getBalance());
					}
				}

			} else if (input == 3) {
				System.out.println("--------");
				System.out.println("예금");
				System.out.println("--------");

				System.out.printf("계좌번호: ");
				accountNum = scan.nextLine();
				System.out.printf("예금액: ");
				money = Integer.parseInt(scan.nextLine());

				for (int i = 0; i < accountArr.length; i++) {
					if (accountArr[i] != null && accountArr[i].getAccountNum().equals(accountNum)) {
						accountArr[i].deposit(money);
					}
				}

			} else if (input == 4) {
				System.out.println("--------");
				System.out.println("출금");
				System.out.println("--------");

				System.out.printf("계좌번호: ");
				accountNum = scan.nextLine();
				System.out.printf("출금액: ");
				money = Integer.parseInt(scan.nextLine());

				for (int i = 0; i < accountArr.length; i++) {
					if (accountArr[i] != null && accountArr[i].getAccountNum().equals(accountNum)) {
						accountArr[i].withdraw(money);
						System.out.println("결과: 출금이 성공되었습니다.");
					}
				}

			} else if (input == 5) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

}
