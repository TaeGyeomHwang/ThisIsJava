package ch18;

import java.io.File;
import java.io.IOException;

public class FileExam {

	public static void main(String[] args) throws Exception {
		File dir = new File("C:/Temp2/images");
		File file = new File("C:/Temp3/images/img.jpg");

//		if (!dir.exists())
//			dir.mkdir();
//
//		if (!file.exists())
//			file.mkdirs();
		
		file.createNewFile();
//		file.delete();
		
		if(file.isDirectory()) {
			System.out.println("디렉토리 입니다.");
		}
		if(file.isFile()) {
			System.out.println("파일 입니다.");
		}

	}

}
