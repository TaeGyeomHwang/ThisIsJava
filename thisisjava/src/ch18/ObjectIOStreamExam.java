package ch18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectIOStreamExam {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp2/object.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			Member m1 = new Member("spring", "봄");
			Product p1 = new Product("노트북", 1500000, 1);
			int[] arr = { 1, 2, 3 };
			
			//직렬화
			oos.writeObject(m1);
			oos.writeObject(p1);
			oos.writeObject(arr);
			
			fos.close();
			oos.close();
			
			FileInputStream fis = new FileInputStream("C:/Temp2/object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			//역직렬화
			Member m2 = (Member) ois.readObject();	//object로 반환하지만 내용물은 member니깐 강제 형변환해도 문제 x
			Product p2 = (Product) ois.readObject();
			int[] arr2 = (int[]) ois.readObject();
			
			fis.close();
			ois.close();
			
			System.out.println(m2);
			System.out.println(p2);
			System.out.println(Arrays.toString(arr2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}