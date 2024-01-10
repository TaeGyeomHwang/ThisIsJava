package ch06;

class Account {
	private int balance;

	public int getBalance() { // 잔고 확인
		return this.balance;
	}

	public void setBalance(int money) { // 계좌 개설 시 초기값
		if (money >= 1000) {
			this.balance = money;
		} else {
			System.out.println("1000원 미만의 금액은 계좌를 개설할 수 없습니다.");
		}
	}

	public int withdraw(int money) { // 출금
		if (money > this.balance) {
			System.out.println("출금액이 잔고보다 큽니다.");
			return -1;
		}
		this.balance -= money;
		return this.balance;

	}

}
