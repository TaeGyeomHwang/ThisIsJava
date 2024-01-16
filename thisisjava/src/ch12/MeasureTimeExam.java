package ch12;

public class MeasureTimeExam {

	public static void main(String[] args) {
		long sum = 0;
		double nt1 = System.nanoTime();

		for (int i = 1; i < 1000000; i++) {
			sum += i;
		}

		double nt2 = System.nanoTime();

		System.out.println((nt2 - nt1) / 1000000000);
	}

}
