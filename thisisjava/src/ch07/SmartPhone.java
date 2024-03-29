package ch07;

public class SmartPhone extends Phone{
	public boolean wifi;
	
	public SmartPhone() {
		super();	//	부모의 기본생성자, super는 부모 객체를 가리킨다.
		System.out.println("SmartPhone의 기본생성자");	//	생성자의 호출 순서는 부모생성자, 자식생성자 순으로 이뤄진다.
	}
	
	public SmartPhone(String model, String color) {
		super(model, color);
		System.out.println("SmartPhone(String, String)의 생성자");
	}
	
	public SmartPhone(String model, String color, boolean wifi) {
		super(model, color);
		this.wifi = wifi;	//	부모 생성자에게는 wifi가 없으므로 super 사용 불가.
		System.out.println("SmartPhone(String, String, boolean)의 생성자");
	}
	
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경합니다.");
	}
	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}
}
