package ch19;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPExam {

	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println(local.getHostAddress());
			
			InetAddress[] naver = InetAddress.getAllByName("www.naver.com");
			for(InetAddress i : naver) {
				System.out.println(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
