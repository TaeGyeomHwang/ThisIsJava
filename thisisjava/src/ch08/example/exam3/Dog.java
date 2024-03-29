package ch08.example.exam3;

public class Dog extends Pet {
	String breed;
	Boolean vaccine;

	public Dog(String name, int age, String breed, String vaccine) {
		this.name = name;
		this.age = age;
		this.breed = breed;
		if (vaccine.equals("예")) {
			this.vaccine = true;
		} else {
			this.vaccine = false;
		}
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
	public int getAge() {
		return this.age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	public String getBreed() {
		return this.breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public boolean getVaccine() {
		return this.vaccine;
	}

	public void setVaccine(boolean vaccine) {
		this.vaccine = vaccine;
	}

	public String vaccineStr(boolean b) {
		if (b == true) {
			return "예방주사를 맞았다.";
		} else {
			return "예방주사를 맞지 않았다.";
		}
	}

	@Override
	public String getInfo() {
		return "\n이름: " + this.getName() + "\n나이: " + this.getAge() + "\n품종: " + this.getBreed() + "\n"
				+ vaccineStr(this.getVaccine());
	}

	@Override
	public String isVaccinated() {
		if (this.getAge() > 2 && this.getVaccine() == false) {
			return "이름: " + this.getName() + ", 나이: " + this.getAge();
		}else {
			return "";
		}

	}

}
