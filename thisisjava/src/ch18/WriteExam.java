package ch18;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExam {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("C:/Temp2/test1.txt");	//������ ������ ����
		
		byte a = 10;
		byte b = 20;
		byte c = 30;
		
		os.write(a);
		os.write(b);
		os.write(c);
		
		os.flush();	//���۸� ���
		os.close();	//����� �޸� ����
		
	}

}