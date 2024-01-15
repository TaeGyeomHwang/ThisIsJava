package ch07;

public class Computer extends Calculator{
	@Override
	public double areaCircle(double r) {
		super.areaCircle(r); //	부모 클래스의 메서드를 호출하고 싶다면 사용.
		System.out.println("Computer.areaCircle() 입니다.");
		return r * r * Math.PI;
	}

}
