package ch18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyExam {

	public static void main(String[] args) {

//		System.out.println(originalPath);
		try {
			String originalPath = FileCopyExam.class.getResource("image.jpg").getPath(); // url�̶�� ��ü�� getpath() �޼ҵ带 ���� ��η� ����
			
			FileInputStream fis = new FileInputStream(originalPath);
			FileOutputStream fos = new FileOutputStream("C:/Temp2/targetFile.jpg");
			long start = System.nanoTime();
			while (true) {
				int data = fis.read();
				if (data == -1)
					break;
				fos.write(data);
			}
			System.out.println("�⺻ ���Ͻ�Ʈ�� �ɸ� �ð�: " + (System.nanoTime() - start));

			
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			start = System.nanoTime();
			while (true) {
				int data = fis.read();
				if (data == -1)
					break;
				bos.write(data);
			}
			System.out.println("���� ���� ��Ʈ�� �ɸ� �ð�: " + (System.nanoTime() - start));
			bis.close();
			bos.flush();
			bos.close();
			
			fis.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
