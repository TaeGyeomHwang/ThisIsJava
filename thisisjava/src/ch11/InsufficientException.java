package ch11;

public class InsufficientException extends Exception {
	public InsufficientException() {

	}
	public InsufficientException(String message) {
		super(message);	//	익셉션 객체의 공통 메소드인 getMessage의 리턴값으로 사용하기 위해 예외 메시지를 입력받는 생성자 선언
	}
}