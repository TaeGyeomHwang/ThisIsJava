package ch06.practice;

public class Account {
	int balance;
	String accountNum;
	String name;
	int money;

	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;

	Account(String accountNum, String name, int balance) {
		this.accountNum = accountNum;
		this.name = name;
		this.balance = balance;
	}

	public int getBalance() {
		return this.balance;
	}

	public String getName() {
		return this.name;
	}

	public String getAccountNum() {
		return this.accountNum;
	}

	public int deposit(int money) {
		if (this.balance + money >= MIN_BALANCE && this.balance + money <= MAX_BALANCE) {
			return this.balance += money;
		} else {
			return -1;
		}
	}

	public int withdraw(int money) {
		if (this.balance - money >= MIN_BALANCE && this.balance - money <= MAX_BALANCE) {
			return this.balance -= money;
		} else {
			return -1;
		}
	}

}
