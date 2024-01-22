package ch18;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExam {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("C:/Temp2/test1.txt");
		while (true) {
			int data = is.read();
			if (data == -1)
				break;
			System.out.println(data);
		}
		is.close();
	}

}
