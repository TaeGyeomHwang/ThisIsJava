package ch19;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExam {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",50001);
			System.out.println("[Ŭ���̾�Ʈ] ���� ����");
			socket.close();
			System.out.println("[Ŭ���̾�Ʈ] ���� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
