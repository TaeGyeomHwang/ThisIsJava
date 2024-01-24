package ch14;

import java.awt.Toolkit;

public class CreateThreadExam {

	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();

//		Thread thread = new Thread() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 5; i++) {
//					System.out.println("띵");
//					try {
//						Thread.sleep(500);
//					} catch (Exception e) {
//					}
//				}
//			}
//		};
//		thread.start();
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("띵");
					try {
						Thread.sleep(500);
					} catch (Exception e) {
					}
				}
			}
		});
		thread.start();
		
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}

	}

}
