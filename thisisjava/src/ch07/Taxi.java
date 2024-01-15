package ch07;

public class Taxi extends Vehicle{	//	is a 관계
	@Override
	public void run(String name) {
		super.run(name);
		System.out.println("택시가 달립니다.");
	}
}
