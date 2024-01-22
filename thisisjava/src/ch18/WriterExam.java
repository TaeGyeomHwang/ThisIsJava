package ch18;

import java.io.FileWriter;
import java.io.Writer;

public class WriterExam {

	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("C:/Temp2/test2.txt");

		char a = 'A';
		writer.write(a);
		char b = 'B';
		writer.write(b);

		char[] arr = { 'A', 'B', 'C', 'D', 'E' };
		writer.write(arr, 2, 3);
		writer.write("FG");
		
		writer.flush();
		writer.close();
	}

}
