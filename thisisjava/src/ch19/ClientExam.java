package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientExam {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",50001);
			System.out.println("[Ŭ���̾�Ʈ] ���� ����");
			
			String semdMessage = "�������� ���� �޽���";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(semdMessage);
			dos.flush();
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receiveMessage = dis.readUTF();
			System.out.println("�����κ��� ���� �޽���: "+receiveMessage);
			
			socket.close();
			System.out.println("[Ŭ���̾�Ʈ] ���� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
