package ch09;

public class Home {
	private RemoteCon rc = new RemoteCon() {

		@Override
		public void turnOn() {
			System.out.println("전원을 켭니다.");
		}

		@Override
		public void turnOff() {
			System.out.println("전원을 끕니다.");
		}
		

	};
	
	public void use1() {
		rc.turnOn();
		rc.turnOff();
	}
}
