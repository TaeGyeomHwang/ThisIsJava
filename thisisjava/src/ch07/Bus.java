package ch07;

public class Bus extends Vehicle{	//	is a 관계
	@Override
	public void run(String name) {
		super.run(name);
		System.out.println("버스가 달립니다.");
	}
}
