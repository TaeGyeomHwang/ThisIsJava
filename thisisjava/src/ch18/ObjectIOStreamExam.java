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

			Member m1 = new Member("spring", "��");
			Product p1 = new Product("��Ʈ��", 1500000, 1);
			int[] arr = { 1, 2, 3 };
			
			//����ȭ
			oos.writeObject(m1);
			oos.writeObject(p1);
			oos.writeObject(arr);
			
			fos.close();
			oos.close();
			
			FileInputStream fis = new FileInputStream("C:/Temp2/object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			//������ȭ
			Member m2 = (Member) ois.readObject();	//object�� ��ȯ������ ���빰�� member�ϱ� ���� ����ȯ�ص� ���� x
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
