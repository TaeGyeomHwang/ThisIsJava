package ch18;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExam {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("C:/Temp2/test1.txt");
		
		byte[] data = new byte[1024];

		while (true) {
			int num = is.read(data);
			if(num == -1) break;
			for(int i=0; i<num; i++) {
				System.out.println(data[i]);
			}
		}
		is.close();

	}

}
