package ch07;

public class SmartPhoneExam {
	
	public static void main(String[] args) {
		//	상속 시 생성자 생성 순서
		SmartPhone myPhone = new SmartPhone("아이폰", "검정", false);

		myPhone.model = "아이폰";
		myPhone.color = "검정";
		myPhone.wifi = false;

		System.out.println("모델: " + myPhone.model);
		System.out.println("색상: " + myPhone.color);
		System.out.println("와이파이: " + myPhone.wifi);
	}

}
