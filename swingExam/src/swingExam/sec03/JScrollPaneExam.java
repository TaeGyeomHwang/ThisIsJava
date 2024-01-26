package swingExam.sec03;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class JScrollPaneExam extends JFrame {

	private JScrollPane scrollImage;
	private JLabel lblImage;

	// 메인 윈도우 설정
	public JScrollPaneExam() {
		this.setTitle("JScrollPaneExam");
		this.setSize(350, 230);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// JFrame 중앙에 JScrollPane 추가
		this.getContentPane().add(getScrollImage(), BorderLayout.CENTER);
	}

	// JScrollPane 생성
	private JScrollPane getScrollImage() {
		if (scrollImage == null) {
			scrollImage = new JScrollPane(getLblImage());
		}
		return scrollImage;
	}

	// JLabel 생성
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel();
			lblImage.setIcon(new ImageIcon(getClass().getResource("../image3.jpg")));
		}
		return lblImage;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JScrollPaneExam jFrame = new JScrollPaneExam();
			jFrame.setVisible(true);
		});
	}

}
