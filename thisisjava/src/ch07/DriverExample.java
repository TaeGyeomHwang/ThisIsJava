package ch07;

public class DriverExample {

	public static void main(String[] args) {
		Driver driver = new Driver("김김김");
		
		Bus bus = new Bus();
		driver.vehicle = bus;
		driver.drive(bus);
		
		Taxi taxi = new Taxi();
		driver.vehicle = taxi;
		driver.drive(taxi);
	}

}
