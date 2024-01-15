package ch07;

public class SupersonicAirplane extends Airplane{
	
	public FlyMode flymode = FlyMode.NORMAL;
	
	@Override
	public void fly() {
		if(this.flymode == FlyMode.SUPERSONIC) {
			System.out.println("초음속 비행합니다.");
		}else {
			super.fly();
		}
	}
}
