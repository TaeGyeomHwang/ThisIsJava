package swingExam.sec14;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ImageExam extends JFrame {
	public ImageExam() {
		setTitle("이미지 그리기");
		getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
		add(new MyCanvas(), BorderLayout.CENTER);
		setSize(500, 350);
	}

	public class MyCanvas extends Canvas {
		private Image imgBass1, imgBass2;
		public MyCanvas() {
			setBackground(Color.white);
			
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			imgBass1 = toolkit.getImage(getClass().getResource("../image2.jpg"));
			imgBass2 = toolkit.getImage(getClass().getResource("../image3.jpg"));
		}
		
		public void paint(Graphics g) {
			g.drawImage(imgBass1, 10, 10, this);
			g.drawImage(imgBass2, 300, 20, this);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ImageExam jFrame = new ImageExam();
			jFrame.setVisible(true);
		});
	}

}
