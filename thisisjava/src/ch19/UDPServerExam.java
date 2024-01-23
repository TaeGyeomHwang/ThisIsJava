package ch19;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UDPServerExam {

	private static DatagramSocket datagramSocket = null;
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);
	
	public static void main(String[] args) {
		System.out.println("------------------------------------------");
		System.out.println("������ �����Ϸ��� Q �Ǵ� q�� �Է����ּ���.");
		System.out.println("------------------------------------------");

		start();

		Scanner sc = new Scanner(System.in);
		while (true) {
			String key = sc.nextLine();
			if (key.toLowerCase().equals("q"))
				break;
		}
		sc.close();

		stop();
	}

	private static void start() { // ������ ����
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					datagramSocket = new DatagramSocket(50001); // ��Ʈ ���ε�
					System.out.println("[����] UDP ���� ���۵�");

					while (true) {
						DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024); // DatagramPacket�� ������
																									// ����
						datagramSocket.receive(receivePacket);
						

						executorService.execute(()->{
							try {
								String newsKind = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");

								SocketAddress socketAddress = receivePacket.getSocketAddress(); // Ŭ���̾�Ʈ�� ip�� ��Ʈ get

								for (int i = 1; i <= 5; i++) { // ������ Ŭ���̾�Ʈ�� ����(TCP�� �޸� ���� ��ٸ��� �ʰ� ����)
									String data = newsKind + ": ����" + i;
									byte[] bytes = data.getBytes("UTF-8");
									DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, socketAddress);
									datagramSocket.send(sendPacket);
								}
							}catch(Exception e) {
								System.out.println("[����]: " + e.getMessage());
							}
						});
					}
				} catch (Exception e) {
					System.out.println("[����]: " + e.getMessage());
				}
			}
		};
		thread.start();
	}

	private static void stop() {
		datagramSocket.close(); // ��Ʈ ����ε�
		System.out.println("[����] UDP ���� �����");
	}
}
