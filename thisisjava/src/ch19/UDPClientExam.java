package ch19;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UDPClientExam {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			// DatagramSocket 생성
			DatagramSocket datagramSocket = new DatagramSocket();

			while (true) {
				// 전송할 주제 보내기
				System.out.print("구독할 뉴스 주제를 입력하세요. 종료를 원하면 q 입력 > ");
				String data = scan.nextLine();
				
				if (data.toLowerCase().equals("q")) {
					System.out.println("클라이언트를 종료합니다.");
					break;
				}
				
				byte[] bytes = data.getBytes("UTF-8");
				DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length,
						new InetSocketAddress("localHost", 50001));
				datagramSocket.send(sendPacket);

				while(true) {
					// 데이터 받기(UDP이므로 요청 보내자마자 데이터 받을 준비 안하면 데이터를 못받음)
					DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
					datagramSocket.receive(receivePacket);
					
					// 문자열로 변환
					String news = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
					System.out.println(news);

					// 원하는 만큼 받고 while문 종료
					if (news.contains("뉴스5")) {
						System.out.println();
						break;
					}
				}
			}
			// DatagramSocket 닫기
			datagramSocket.close();
		} catch (Exception e) {

		}
	}

}