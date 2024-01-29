package swingExam.sec14;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import swingExam.sec13.JColorExam;

public class CanvasExam extends JFrame {
	public CanvasExam() {
		setTitle("paint()메소드는 언제 호출될까요?");
		getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
		setSize(300, 200);
	}

	public class MyCanvas extends Canvas {
		public void paint(Graphics g) {
			g.drawString("윈도우 창을 줄이거나 늘려보세요", 50, 80);
			System.out.println("paint() 메소드 실행");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			CanvasExam jFrame = new CanvasExam();
			jFrame.setVisible(true);
		});
	}

}
