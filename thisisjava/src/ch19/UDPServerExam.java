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

	private static void start() { // 스레드 시작
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					datagramSocket = new DatagramSocket(50001); // 포트 바인딩
					System.out.println("[서버] UDP 서버 시작됨");

					while (true) {
						DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024); // DatagramPacket의 사이즈
																									// 설정
						datagramSocket.receive(receivePacket);
						

						executorService.execute(()->{
							try {
								String newsKind = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");

								SocketAddress socketAddress = receivePacket.getSocketAddress(); // 클라이언트의 ip와 포트 get

								for (int i = 1; i <= 5; i++) { // 뉴스를 클라이언트로 전송(TCP와 달리 응답 기다리지 않고 보냄)
									String data = newsKind + ": 뉴스" + i;
									byte[] bytes = data.getBytes("UTF-8");
									DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, socketAddress);
									datagramSocket.send(sendPacket);
								}
							}catch(Exception e) {
								System.out.println("[서버]: " + e.getMessage());
							}
						});
					}
				} catch (Exception e) {
					System.out.println("[서버]: " + e.getMessage());
				}
			}
		};
		thread.start();
	}

	private static void stop() {
		datagramSocket.close(); // 포트 언바인딩
		System.out.println("[서버] UDP 서버 종료됨");
	}
}
