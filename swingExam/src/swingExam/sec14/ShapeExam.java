package swingExam.sec14;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ShapeExam extends JFrame {
	public ShapeExam() {
		setTitle("도형 그리기");
		getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
		setSize(400, 300);
	}

	public class MyCanvas extends Canvas {
		public void paint(Graphics g) {
			g.drawOval(50, 50, 50, 50);
			g.setColor(Color.green);
			g.fillOval(50, 100, 50, 50);

			g.setColor(Color.red);
			g.drawLine(50, 100, 100, 150);
			g.drawLine(150, 50, 50, 150);

			g.setColor(Color.BLUE);
			g.drawRoundRect(200, 50, 120, 80, 30, 30);
			g.setColor(Color.YELLOW);
			g.fillRoundRect(250, 100, 120, 80, 30, 30);

			g.setColor(Color.orange);
			g.fillPolygon(new int[] { 50, 100, 150, 200 }, new int[] { 250, 200, 200, 250 }, 4);
			
			g.setColor(Color.cyan);
			g.fillArc(250, 200, 100, 100, 45, 120);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ShapeExam jFrame = new ShapeExam();
			jFrame.setVisible(true);
		});
	}

}
