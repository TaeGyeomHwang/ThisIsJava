package ch08;

public class MultipleInterfaceImplExample {

	public static void main(String[] args) {
//		RemoteCon rc = new SmartTelevisionImpl();
//		rc.turnOn();
//		rc.turnOff();
//		
//		Searchable searchable = new SmartTelevisionImpl();
//		searchable.search("https://www.youtube.com");
		
		SmartTelevision st = new SmartTelevisionImpl();
		st.turnOn();
		st.turnOff();
		st.search("https://www.youtube.com");
	}

}
