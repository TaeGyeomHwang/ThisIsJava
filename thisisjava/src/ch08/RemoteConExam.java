package ch08;

public class RemoteConExam {

	public static void main(String[] args) {
		//	인터페이스 타입은 그 구현 클래스를 모두 담을 수 있음
		//	그 타입에 명시된 메서드만 visible함.
		RemoteControl rc;
		
		//	인터페이스는 설계도의 개념이라 구현할 수 없다.
//		RemoteControl rc = new RemoteControl(); 같은 표현은 틀린 것.
		
		//	rc라는 객체는 인터페이스에게 메소드를 호출하면 인터페이스가 알아서 리턴값을 맞게 돌려주는 것
		rc = new Television();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		rc.setMute(true);
		rc.setMute(false);
		
		System.out.println("");
		
		rc= new Audio();
		rc.turnOn();
		rc.setVolume(11);
		rc.turnOff();
		rc.setMute(true);
		rc.setMute(false);
		
		System.out.println("");
		
		RemoteControl.chanegBattery();
	}

}
