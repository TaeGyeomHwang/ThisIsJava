package swingExam.sec14;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BackgroundExam extends JFrame {
	private JTextField txtId;
	private JButton btnLogin;

	public BackgroundExam() {
		this.setTitle("배경 그림 넣기");
		this.getContentPane().add(new MyPanel(), BorderLayout.CENTER);
		this.setSize(200, 270);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public class MyPanel extends JPanel {
		public MyPanel() {
			setLayout(null);
			add(getTxtField());
			add(getButton());
		}

		@Override
		public void paintComponent(Graphics g) {
			ImageIcon icon = new ImageIcon(this.getClass().getResource("../image1.jpg"));
			g.drawImage(icon.getImage(), 0, 0, this);
		}
	}

	public JTextField getTxtField() {
		if (txtId == null) {
			txtId = new JTextField();
			txtId.setBounds(50, 50, 100, 30);
		}
		return txtId;
	}

	public JButton getButton() {
		if (btnLogin == null) {
			btnLogin = new JButton("버튼");
			btnLogin.setBounds(50, 100, 100, 30);
		}
		return btnLogin;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			BackgroundExam jFrame = new BackgroundExam();
			jFrame.setVisible(true);
		});
	}

}
