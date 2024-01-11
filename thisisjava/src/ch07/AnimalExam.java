package ch07;

public class AnimalExam {

	public static void main(String[] args) {
//		Animal animal = new Animal();	//	추상 클래스는 구현 불가.
		Cat cat = new Cat();
		animalSound(cat);
		
		Dog dog = new Dog();
		animalSound(dog);
	}
	
	public static void animalSound(Animal animal) {	//	Animal을 상속받을 때 모든 자식이 sound 메소드를 가지기 때문에 구현 가능.
		animal.sound();
	}

}
