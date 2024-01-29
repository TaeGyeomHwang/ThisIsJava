package swingExam.sec14;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AntiAliasingExam extends JFrame{
	public AntiAliasingExam() {
		setTitle("안티알리아싱");
		getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
		setSize(200,350);
	}
	
	public class MyCanvas extends Canvas{
		public void paint(Graphics g) {
			g.fillOval(50, 50, 100, 100);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.fillOval(50, 200, 100, 100);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			AntiAliasingExam jFrame = new AntiAliasingExam();
			jFrame.setVisible(true);
		});
	}

}
