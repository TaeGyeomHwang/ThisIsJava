package swingExam.sec14;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ColorExam extends JFrame {

	public ColorExam() {
		setTitle("ColorExam");
		getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
		setSize(300, 200);
	}

	public class MyCanvas extends Canvas {
		public void paint(Graphics g) {
			g.setColor(Color.blue);
			g.setFont(new Font("돋움체", Font.BOLD | Font.ITALIC, 30));
			g.drawString("Color and Font", 20, 100);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ColorExam jFrame = new ColorExam();
			jFrame.setVisible(true);
		});
	}

}
