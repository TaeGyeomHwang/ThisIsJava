package ch18;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExam {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp2/print.txt");
			PrintStream ps = new PrintStream(fos);
			
			ps.print("��ġ ");	//�ҽ��� System.out�� ���� ����� �Ǵ� ��θ� �ֿܼ��� ���Ϸ� �ٲ���.
			ps.println("�����Ͱ� ����ϴ� ��ó�� ");
			ps.println("�����͸� ����մϴ�. ");
			ps.printf("| %6d | %-10s | %10s | \n", 1, "ȫ�浿", "����");
			ps.printf("| %6d | %-10s | %10s | \n", 2, "���ڹ�", "�л�");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
