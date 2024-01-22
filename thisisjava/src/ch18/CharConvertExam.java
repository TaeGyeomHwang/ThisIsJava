package ch18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharConvertExam {

	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:/Temp2/test3.txt");
			Writer writer = new OutputStreamWriter(os, "UTF-8");

			writer.write("���� ��ȯ ��Ʈ���� ����մϴ�.");
			writer.flush();
			writer.close();

			FileInputStream is = new FileInputStream("C:/Temp2/test3.txt"); // �⺻ ����Ʈ �Է� ��Ʈ��
			Reader reader = new InputStreamReader(is, "UTF-8"); // Reader�� ��ȯ���ִ� ������Ʈ��

			char[] data = new char[100];
			int num = reader.read(data); // �迭 �뷮��ŭ ������ �о����, �о�� ������ ���� ����
			String str = new String(data, 0, num);	//	���� �迭�� ������(data)���� ���̸�ŭ ���ڷ� ����
			System.out.println(str);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
