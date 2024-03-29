package ch07;

public class Phone {
	public String model;
	public String color;
	
	Phone(){
		System.out.println("phone 기본생성자");
	}
	
	public Phone(String model, String color) {
		this.model = model;
		this.color = color;
		System.out.println("phone(String, String) 생성자");
	}
	
	public void bell() {
		System.out.println("벨이 울립니다.");
	}
	
	public void sendVoice(String message) {
		System.out.println("나: "+message);
	}
	
	public void receiveVoice(String message) {
		System.out.println("상대: "+message);
	}
	
	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
}
