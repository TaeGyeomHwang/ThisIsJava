package ch18;

import java.io.Serializable;

public class Member implements Serializable{	//����ȭ�� �����ϴٰ� ����ϴ� ����. 
	/**
	 * 
	 */
	private static final long serialVersionUID = -1616065040391964919L;	//���� Ű�� �־���
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
