package ch19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerExam {

	private static ServerSocket serverSocket = null;
	// ������Ǯ ����(���� ������ �� 10������ ����)
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
					serverSocket = new ServerSocket(50001);
					System.out.println("���� ���۵�.");

					while (true) {
						// 50001��Ʈ�� ������ ���ο� ������ ��ٸ�, ����� ���� ���� ���� ��ü ����
						System.out.println("[����] ������ ��ٸ�");
						Socket socket = serverSocket.accept();

						// accept �Ҷ����� ������Ǯ�� task�� �߰�.
						executorService.execute(() -> {
							try {
								InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
								System.out.println("[����] " + isa.getHostName() + "�� ������ ������");

								DataInputStream dis = new DataInputStream(socket.getInputStream());
								String message = dis.readUTF();

								DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
								dos.writeUTF(message);
								dos.flush();
								System.out.println("�������� ���� ������  \"" + message + "\"�� ����");

								socket.close();
								System.out.println("[����] " + isa.getHostName() + "�� ������ ������");
							} catch (Exception e) {
								System.out.println("[����] " + e.getMessage());
							}
						});
					}
				} catch (Exception e) {
					System.out.println("[����] " + e.getMessage());
				}
			}
		};
		thread.start();
	}

	private static void stop() { // ������ ����
		try {
			serverSocket.close();
		} catch (Exception e) {
			System.out.println("[����] " + e.getMessage());
		}
	}
}
