package ch18;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExam {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("C:/Temp2/test1.txt");	//데이터 도착지 지정
		
		byte a = 10;
		byte b = 20;
		byte c = 30;
		
		os.write(a);
		os.write(b);
		os.write(c);
		
		os.flush();	//버퍼를 비움
		os.close();	//사용한 메모리 해제
		
	}

}