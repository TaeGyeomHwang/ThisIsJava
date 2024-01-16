package ch12;

public class PropertyExam {
	public static void main(String[] args) {
		System.out.println(System.getProperty("java.specification.version"));
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("os.name"));
//		if(System.getProperty("os.name").split(" ")[0].equals("Windows")){
//		System.out.println("윈도우 운영체제입니다.");
//		}
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("user.dir"));
	}
}
