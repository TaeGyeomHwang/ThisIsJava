package ch18;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7394135165810371117L;
	private static String company = "�Ｚ";	//�����ڿ� ���� �ʵ�� ���� �ȵ�
	private String name;
	private int price;
	private transient int pid;	//����ȭ���� ���ִ� Ű���� (���� ��� ��). ��Ÿ�� �߿����� Ȯ�� ����
	
}
