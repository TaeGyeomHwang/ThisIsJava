package ch19;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UDPClientExam {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			// DatagramSocket ����
			DatagramSocket datagramSocket = new DatagramSocket();

			while (true) {
				// ������ ���� ������
				System.out.print("������ ���� ������ �Է��ϼ���. ���Ḧ ���ϸ� q �Է� > ");
				String data = scan.nextLine();
				
				if (data.toLowerCase().equals("q")) {
					System.out.println("Ŭ���̾�Ʈ�� �����մϴ�.");
					break;
				}
				
				byte[] bytes = data.getBytes("UTF-8");
				DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length,
						new InetSocketAddress("localHost", 50001));
				datagramSocket.send(sendPacket);

				while(true) {
					// ������ �ޱ�(UDP�̹Ƿ� ��û �����ڸ��� ������ ���� �غ� ���ϸ� �����͸� ������)
					DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
					datagramSocket.receive(receivePacket);
					
					// ���ڿ��� ��ȯ
					String news = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
					System.out.println(news);

					// ���ϴ� ��ŭ �ް� while�� ����
					if (news.contains("����5")) {
						System.out.println();
						break;
					}
				}
			}
			// DatagramSocket �ݱ�
			datagramSocket.close();
		} catch (Exception e) {

		}
	}

}
