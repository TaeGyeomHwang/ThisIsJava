package ch08.example.exam3;

public abstract class Pet {
	String name;
	int age;
	
	public abstract String getName();
	public abstract void setName(String name);
	public abstract int getAge();
	public abstract void setAge(int age);
	public abstract String getInfo();
	public abstract String isVaccinated();
}
