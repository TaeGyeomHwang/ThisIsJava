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
	// 스레드풀 설정(동시 접속자 수 10명으로 제한)
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		System.out.println("------------------------------------------");
		System.out.println("서버를 종료하려면 Q 또는 q를 입력해주세요.");
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

	private static void start() { // 스레드 실행
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("서버 시작됨.");

					while (true) {
						// 50001포트로 들어오는 새로운 유저를 기다림, 연결시 유저 정보 담은 객체 생성
						System.out.println("[서버] 연결을 기다림");
						Socket socket = serverSocket.accept();

						// accept 할때마다 스레드풀의 task에 추가.
						executorService.execute(() -> {
							try {
								InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
								System.out.println("[서버] " + isa.getHostName() + "의 연결을 수락함");

								DataInputStream dis = new DataInputStream(socket.getInputStream());
								String message = dis.readUTF();

								DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
								dos.writeUTF(message);
								dos.flush();
								System.out.println("서버에서 받은 데이터  \"" + message + "\"를 보냄");

								socket.close();
								System.out.println("[서버] " + isa.getHostName() + "의 연결을 종료함");
							} catch (Exception e) {
								System.out.println("[서버] " + e.getMessage());
							}
						});
					}
				} catch (Exception e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		thread.start();
	}

	private static void stop() { // 스레드 종료
		try {
			serverSocket.close();
		} catch (Exception e) {
			System.out.println("[서버] " + e.getMessage());
		}
	}
}