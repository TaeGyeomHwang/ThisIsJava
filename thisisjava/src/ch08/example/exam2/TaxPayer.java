package ch08.example.exam2;

public abstract class TaxPayer {
	String name;
	int num;
	
	public abstract String getName();
	public abstract void setName(String name);
	public abstract int getNum();
	public abstract void setNum(int num);
	public abstract String getInfo();
	public abstract Double calcTax();
}
