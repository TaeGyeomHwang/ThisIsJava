package ch18;

import java.io.Serializable;

public class Member implements Serializable{	//직렬화가 가능하다고 명시하는 역할. 
	/**
	 * 
	 */
	private static final long serialVersionUID = -1616065040391964919L;	//랜덤 키값 주어짐
	private String id;
	private String name;
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + "]";
	}
}
