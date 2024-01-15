package ch11;

public class AccountExample {

	public static void main(String[] args) {
		Account account = new Account();

		account.deposit(10000);
		System.out.println("예금액: " + account.getBalance());

		try {
			account.withdraw(30000);
		} catch (InsufficientException e) {	//	예외 처리 코드와 함께 withdraw() 메소드 호출
			String message = e.getMessage();
			System.out.println(message);
		}
	}

}
