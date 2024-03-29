package ch08.example.exam1;

public class Car extends Vehicle {
	int cc;

	public Car(String name, int price, int cc) {
		this.name = name;
		this.price = price;
		this.cc = cc;
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

	public int getCc() {
		return this.cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	@Override
	public String getInfo() {
		return "모델 명: " + this.getName() + ", 가격: " + this.getPrice() + ", 배기량: " + this.getCc();
	}

	@Override
	public Double calcTax() {
		double tax = 0.0;
		if (this.getCc() >= 3000) {
			tax = this.getPrice() * 0.05;
		} else if (this.getCc() < 3000 && this.getCc() >= 1500) {
			tax = this.getPrice() * 0.03;
		} else {
			tax = this.getPrice() * 0.01;
		}
		return tax;
	}

}
