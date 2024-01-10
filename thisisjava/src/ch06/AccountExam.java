package ch06;

public class AccountExam {

	public static void main(String[] args) {
		Account ac = new Account();
		int myBalance = ac.getBalance();
		System.out.println(myBalance);
		ac.setBalance(10000);
		ac.withdraw(1000);
		myBalance = ac.getBalance();
		System.out.println(myBalance);

	}

}
