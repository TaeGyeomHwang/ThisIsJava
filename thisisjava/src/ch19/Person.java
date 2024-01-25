package ch19;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	private String id;
	private String name;
	private int age;
	private boolean student;
	private Tel tel;
	private String[] skill;
	
}
