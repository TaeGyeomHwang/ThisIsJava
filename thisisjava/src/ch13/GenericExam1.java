package ch13;

public class GenericExam1 {

	public static void main(String[] args) {
		Product<Tv, String> product1 = new Product<>();
		product1.setKind(new Tv());
		product1.setModel("삼성 TV");

		Tv tv = product1.getKind();
		System.out.println(product1.getModel());
		
		Product<Car, String> product2 = new Product<>();
		product2.setKind(new Car());
		product2.setModel("현대 자동차");
		
		Car car = product2.getKind();
		System.out.println(product2.getModel());
	}

}
