package ch19;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExam {

	private static ServerSocket serverSocket = null;

	public static void main(String[] args) {
		System.out.println("------------------------------------------");
		System.out.println("서버를 종료하려면 Q 또는 q를 입력해주세요.");
		System.out.println("------------------------------------------");

		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					serverSocket = new ServerSocket(50001);

					System.out.println("서버 시작됨.");

					while (true) {
						System.out.println("[서버] 연결을 기다림");
						Socket socket = serverSocket.accept(); // 50001포트로 들어오는 클라이언트를 기다림, 연결시 클라이언트 정보 담은 객체 생성

						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[서버] " + isa.getHostName() + "의 연결을 수락함");

						socket.close();
						System.out.println("[서버] " + isa.getHostName() + "의 연결을 종료함");
					}
				} catch (Exception e) {
					System.out.println("[서버] " + e.getMessage());
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
			System.out.println("[서버] " + e.getMessage());
		}
	}

}
