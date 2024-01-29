package swingExam.sec13;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JFrameExam extends JFrame {
	private JButton btnOpenDialog;

	public JFrameExam() {
		this.setTitle("JFrame");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(getBtnOpenDialog(), BorderLayout.SOUTH);
	}
	
	private JButton getBtnOpenDialog() {
		if(btnOpenDialog ==null) {
			btnOpenDialog = new JButton();
			btnOpenDialog.setText("다이얼로그 띄우기");
			btnOpenDialog.addActionListener(e->{
				JDialogExam jDialog = new JDialogExam(JFrameExam.this);
				jDialog.setVisible(true);
			});
		}
		return btnOpenDialog;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			JFrameExam jFrame = new JFrameExam();
			jFrame.setVisible(true);
		});
	}

}
