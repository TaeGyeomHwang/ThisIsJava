package swingExam.sec04;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class NullLayoutExam extends JFrame {

	private JButton btnOk;

	// 메인 윈도우 설정
	public NullLayoutExam() {
		this.setTitle("NullLayoutExam");
		this.setSize(300, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// NullLayout 설정과 버튼 추가
		this.getContentPane().setLayout(null);
		this.getContentPane().add(getBtnOk());
	}

	// 버튼 생성
	public JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton();
			btnOk.setText("확인");
			// 버튼이 위치할 좌표값과 폭과 높이 설정
			btnOk.setBounds(100, 50, 70, 60);
		}
		return btnOk;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			NullLayoutExam jFrame = new NullLayoutExam();
			jFrame.setVisible(true);
		});
	}

}
