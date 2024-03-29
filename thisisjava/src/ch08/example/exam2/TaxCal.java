package ch08.example.exam2;

import java.math.BigDecimal;

public class TaxCal {

	public static void main(String[] args) {
		TaxPayer sunnam = new Gueunro("선남", 100, 3000000);
		System.out.println(sunnam.getInfo());
		System.out.println("세금: " + calculate(sunnam));

		TaxPayer sunnyeo = new Saup("선녀", 200, 120000000, 75000000);
		System.out.println(sunnyeo.getInfo());
		System.out.println("세금: " + calculate(sunnyeo));
	}

	private static BigDecimal calculate(TaxPayer t) {
		BigDecimal big = new BigDecimal(t.calcTax());
		return big;
	}

}
