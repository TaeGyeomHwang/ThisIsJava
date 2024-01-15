package ch08.example.exam1;

public abstract class Vehicle {
	String name;
	int price;
	
	public abstract String getName();
	public abstract void setName(String name);
	public abstract int getPrice();
	public abstract void setPrice(int price);
	public abstract String getInfo();
	public abstract Double calcTax();
}
