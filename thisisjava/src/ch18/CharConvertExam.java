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

			writer.write("문자 변환 스트림을 사용합니다.");
			writer.flush();
			writer.close();

			FileInputStream is = new FileInputStream("C:/Temp2/test3.txt"); // 기본 바이트 입력 스트림
			Reader reader = new InputStreamReader(is, "UTF-8"); // Reader로 변환해주는 보조스트림

			char[] data = new char[100];
			int num = reader.read(data); // 배열 용량만큼 데이터 읽어오고, 읽어온 데이터 수를 리턴
			String str = new String(data, 0, num);	//	문자 배열의 오프셋(data)에서 길이만큼 문자로 생성
			System.out.println(str);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}