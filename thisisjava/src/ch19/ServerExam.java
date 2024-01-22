package ch19;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExam {

	private static ServerSocket serverSocket = null;

	public static void main(String[] args) {
		System.out.println("------------------------------------------");
		System.out.println("������ �����Ϸ��� Q �Ǵ� q�� �Է����ּ���.");
		System.out.println("------------------------------------------");

		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					serverSocket = new ServerSocket(50001);

					System.out.println("���� ���۵�.");

					while (true) {
						System.out.println("[����] ������ ��ٸ�");
						Socket socket = serverSocket.accept(); // 50001��Ʈ�� ������ Ŭ���̾�Ʈ�� ��ٸ�, ����� Ŭ���̾�Ʈ ���� ���� ��ü ����

						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[����] " + isa.getHostName() + "�� ������ ������");

						socket.close();
						System.out.println("[����] " + isa.getHostName() + "�� ������ ������");
					}
				} catch (Exception e) {
					System.out.println("[����] " + e.getMessage());
				}
			}
		};
		thread.start();

		Scanner sc = new Scanner(System.in);
		while (true) {
			String key = sc.nextLine();
			if (key.toLowerCase().equals("q"))
				break;
		}

		sc.close();
		try {
			serverSocket.close();
		} catch (Exception e) {
			System.out.println("[����] " + e.getMessage());
		}
	}

}
