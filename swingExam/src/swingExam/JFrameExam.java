package swingExam;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JFrameExam extends JFrame {

	public JFrameExam() {
		this.setSize(600, 500);
		this.setIconImage(new ImageIcon(getClass().getResource("image.jpg")).getImage());
		this.setTitle("메인창");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrameExam jFrame = new JFrameExam();
				jFrame.setVisible(true);
			}
		});
	}

}
