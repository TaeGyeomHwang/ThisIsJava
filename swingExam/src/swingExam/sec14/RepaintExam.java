package swingExam.sec14;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class RepaintExam extends JFrame {
	public RepaintExam() {
		setTitle("Repainting");
		getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
		setSize(500, 400);
	}

	public class MyCanvas extends Canvas implements MouseMotionListener {
		private int x;
		private int y;

		public MyCanvas() {
			addMouseMotionListener(this);
		}
		@Override
		public void update(Graphics g) {
			paint(g);
		}
		@Override
		public void paint(Graphics g) {
			g.drawString("*", x, y);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			System.out.println("aaa");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			RepaintExam jFrame = new RepaintExam();
			jFrame.setVisible(true);
		});
	}

}
