package ch07;

public class SealedClassExam {

	public static void main(String[] args) {
		People p = new People();
		Employee e = new Employee();
		Manager m = new Manager();
		Director d = new Director();
		
		p.work();
		e.work();
		m.work();
		d.work();
	}

}
