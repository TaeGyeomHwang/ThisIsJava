package swingExam;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class JTabbedPaneExam extends JFrame {

	private JTabbedPane jTabbedPane;
	private JPanel tab1Panel;
	private JPanel tab2Panel;

	public JTabbedPaneExam() {
		this.setTitle("JTabbedPaneExample");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(getJTabbedPane(), BorderLayout.CENTER); // null인지 검사하기 위해 getter로 만듬.
	}

	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setTabPlacement(JTabbedPane.LEFT); // 탭의 위치 왼쪽으로 지정
			jTabbedPane.addTab("탭1", getTab1Panel());
			jTabbedPane.addTab("탭2", getTab2Panel());
		}
		return jTabbedPane;
	}

	private Component getTab1Panel() {
		if (tab1Panel == null) {
			tab1Panel = new JPanel();
			JLabel jLabel = new JLabel();
			jLabel.setIcon(new ImageIcon(getClass().getResource("image.jpg")));
			tab1Panel.add(jLabel);
		}
		return tab1Panel;
	}

	private Component getTab2Panel() {
		if (tab2Panel == null) {
			tab2Panel = new JPanel();
			JLabel jLabel = new JLabel();
			jLabel.setIcon(new ImageIcon(getClass().getResource("image1.jpg")));
			tab2Panel.add(jLabel);
		}
		return tab2Panel;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JTabbedPaneExam jt = new JTabbedPaneExam();
			jt.setVisible(true);
		});
	}

}
