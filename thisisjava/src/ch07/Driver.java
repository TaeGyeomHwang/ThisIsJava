package ch07;

public class Driver {
	String name;
	Vehicle vehicle;
	
	public void drive(Vehicle vehicle) {	//	has a 관계
		vehicle.run(name);
	}
	
	Driver(String name){
		this.name = name;
	}
}
