package ch19;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
	private String id;
	private String name;
	private int age;
	private boolean student;
	private Tel tel;
	private String[] skill;
	
}
