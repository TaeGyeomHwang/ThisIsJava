package ch18;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataIOStreamExam {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp2/test3.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeUTF("홍길동");
			dos.writeDouble(95.5);
			dos.writeInt(1);

			dos.writeUTF("김자바");
			dos.writeDouble(90.5);
			dos.writeInt(2);

			dos.close();
			fos.close();

			FileInputStream fis = new FileInputStream("C:/Temp2/test3.txt");
			DataInputStream dis = new DataInputStream(fis);

			for (int i = 0; i < 2; i++) {
				String name = dis.readUTF();
				double score = dis.readDouble();
				int num = dis.readInt();
				System.out.println(name + " " + score + " " + num);
			}
			fis.close();
			dis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
