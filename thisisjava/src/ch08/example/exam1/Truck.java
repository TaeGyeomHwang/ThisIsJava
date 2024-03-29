package ch08.example.exam1;

public class Truck extends Vehicle {
	double weight;

	public Truck(String name, int price, double weight) {
		this.name = name;
		this.price = price;
		this.weight = weight;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getPrice() {
		return this.price;
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String getInfo() {
		return "모델 명: " + this.getName() + ", 가격: " + this.getPrice() + ", 적재 중량: " + this.getWeight();
	}

	@Override
	public Double calcTax() {
		double tax = 0.0;
		if (this.getWeight() >= 10000) {
			tax = this.getPrice() * 0.04;
		} else if (this.getWeight() < 10000 && this.getWeight() >= 5000) {
			tax = this.getPrice() * 0.02;
		} else {
			tax = this.getPrice() * 0.01;
		}
		return tax;
	}

}
