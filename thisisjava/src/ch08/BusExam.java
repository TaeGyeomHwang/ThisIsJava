package ch08;

public class BusExam {

	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		vehicle.run();
//		vehicle.checkFare();	//	non-visable 하기 떄문
		
		System.out.println();
		
		Bus bus = (Bus)vehicle;
		bus.run();
		bus.checkFare();
		
		System.out.println();
		
		Vehicle taxi = new Taxi();
		ride(taxi);
		ride(bus);
	}

	static void ride(Vehicle v) {
		v.run();
//		v.checkFare();	//	Bus에는 있지만 Vehicle 에는 없기 때문에 non-visible
		
		if(v instanceof Bus b) {	//	따라서 instanceof 사용.
			b.checkFare();
		}
	}
}
