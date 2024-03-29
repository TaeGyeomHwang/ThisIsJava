package ch08.example.exam3;

import java.util.*;

public class DogDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Pet[] pet = new Pet[2];
		
		for(int i=0; i<pet.length; i++) {
			System.out.printf("개의 이름을 입력하세요: ");
			String name = scan.nextLine();
			System.out.printf("개의 나이를 입력하세요: ");
			int age = Integer.parseInt(scan.nextLine());
			System.out.printf("개의 품종을 입력하세요: ");
			String breed = scan.nextLine();
			System.out.printf("예방주사를 맞았나요(예 혹은 아니오)?: ");
			String vaccine = scan.nextLine();
			
			pet[i] = new Dog(name, age, breed, vaccine);
		}

		for(int i=0; i<pet.length; i++) {
			System.out.println(pet[i].getInfo());
		}
		
		System.out.println();
		System.out.println("다음 개들은 두 살이 넘었으나 예방주사를 맞지 않았다:");
		for(int i=0; i<pet.length; i++) {
			System.out.println(calculate(pet[i]));
		}
	}

	private static String calculate(Pet p) {
		return p.isVaccinated();
	}

}
