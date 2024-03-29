package ch08.example.exam2;

public class Gueunro extends TaxPayer {
	int salary;

	public Gueunro(String name, int num, int salary) {
		this.name = name;
		this.num = num;
		this.salary = salary;
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

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String getInfo() {
		return "이름: " + this.getName() + ", 번호: " + this.getNum() + ", 월급: " + this.getSalary();
	}

	@Override
	public Double calcTax() {
		double tax = 0.0;
		if (this.getSalary() > 80000000) {
			tax = this.getSalary() * 0.3;
		}else if(this.getSalary() > 60000000 && this.getSalary() <= 80000000) {
			tax = this.getSalary() * 0.2;
		}else if(this.getSalary() > 40000000 && this.getSalary() <= 60000000) {
			tax = this.getSalary() * 0.15;
		}else if(this.getSalary() > 20000000 && this.getSalary() <= 40000000) {
			tax = this.getSalary() * 0.1;
		}else {
			tax = this.getSalary() * 0.05;
		}
		return tax;
	}

}
