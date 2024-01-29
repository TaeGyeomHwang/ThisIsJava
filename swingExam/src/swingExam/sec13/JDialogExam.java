package swingExam.sec13;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class JDialogExam extends JDialog {
	private JButton btnClose;

	public JDialogExam(JFrame owner) {
		super(owner);
		this.setTitle("JDialogExam");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setLocation(owner.getLocationOnScreen().x + (owner.getWidth() - this.getWidth()) / 2,
				owner.getLocationOnScreen().y + (owner.getHeight() - this.getHeight()) / 2);
		this.getContentPane().add(getBtnClose(), BorderLayout.SOUTH);
	}

	public JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton();
			btnClose.setText("닫기");
			btnClose.addActionListener(e -> {
				JDialogExam.this.dispose();
			});
		}
		return btnClose;
	}
}
