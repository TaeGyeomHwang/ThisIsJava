package ch07;

public class AirplaneExam {

	public static void main(String[] args) {
		SupersonicAirplane sa = new SupersonicAirplane();
		
		sa.takeOff();
		sa.fly();
		sa.flymode = FlyMode.SUPERSONIC;
		sa.fly();
		sa.flymode = FlyMode.NORMAL;
		sa.fly();
		sa.land();
	}

}
