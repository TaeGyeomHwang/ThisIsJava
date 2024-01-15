package ch08.example.exam1;

public class Driver {

	public static void main(String[] args) {
		Vehicle genesis = new Car("제네시스", 50000000, 3500);
		System.out.println(genesis.getInfo());
		System.out.println("자동차세: " + calculate(genesis));
		
		Vehicle bongo = new Truck("봉고", 20000000, 2500.0);
		System.out.println(bongo.getInfo());
		System.out.println("자동차세: " + calculate(bongo));
		
		Vehicle soul = new Car("쏘울", 15000000, 1000);
		System.out.println(soul.getInfo());
		System.out.println("자동차세: " + calculate(soul));
	}
	
	private static double calculate(Vehicle v) {
		return v.calcTax();
	}

}
