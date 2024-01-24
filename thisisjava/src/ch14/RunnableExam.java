package ch14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExam {

	public static void main(String[] args) {
		String[][] mails = new String[1000][3];
		for (int i = 0; i < mails.length; i++) {
			mails[i][0] = "admin@my.com";
			mails[i][1] = "member" + i + "@my.com";
			mails[i][2] = "신상품 입고";
		}

		ExecutorService ex = Executors.newFixedThreadPool(5); // 최대 스레드 개수, 한번 만들어진 스레드는 사라지지 않음

		for (int i = 0; i < 1000; i++) {
			final int idx = i;
			ex.execute(new Runnable() {
				@Override
				public void run() {
					Thread th = Thread.currentThread();
					String from = mails[idx][0];
					String to = mails[idx][1];
					String content = mails[idx][2];
					System.out.println("[" + th.getName() + "] " + from + " ==> " + to + ": " + content);
				}
			});
		}
		
		ex.shutdown();	//작업 끝낼때까지 기다린 후 종료
//		ex.shutdownNow();	//작업 끝내지 못해도 강제로 종료
	}

}