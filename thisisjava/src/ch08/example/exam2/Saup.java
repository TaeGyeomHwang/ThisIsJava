package ch08.example.exam2;

public class Saup extends TaxPayer {
	int take;
	int expense;

	public Saup(String name, int num, int take, int expense) {
		this.name = name;
		this.num = num;
		this.take = take;
		this.expense = expense;
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
	public int getNum() {
		return this.num;
	}

	@Override
	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String getInfo() {
		return "이름: " + this.getName() + ", 번호: " + this.getNum() + ", 총매출액: " + this.getTake() + ", 총비용: "
				+ this.getExpense();
	}

	private int getExpense() {
		return this.expense;
	}

	private int getTake() {
		return this.take;
	}

	@Override
	public Double calcTax() {
		double tax = this.getTake() - this.getExpense();
		double finalTax = 0.0;
		if (tax > 40000000) {
			finalTax = tax * 0.3;
		} else if (tax > 0 && tax <= 40000000) {
			finalTax = tax * 0.1;
		} else {
			finalTax = 0;
		}
		return finalTax;
	}

}
