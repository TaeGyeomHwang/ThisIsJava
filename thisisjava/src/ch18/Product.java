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
	private static String company = "삼성";	//생성자에 정적 필드는 포함 안됨
	private String name;
	private int price;
	private transient int pid;	//직렬화에서 弧獵 키워드 (예외 라는 뜻). 런타임 중에서만 확인 가능
	
}