package ch12;

import java.io.UnsupportedEncodingException;

public class BytesToString {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String data = "자바";
		byte[] bytes = data.getBytes("EUC-KR");

		String receive = new String(bytes, "EUC-KR");

		System.out.println(receive);

	}

}
