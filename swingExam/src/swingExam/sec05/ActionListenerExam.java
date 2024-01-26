package swingExam.sec05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ActionListenerExam extends JFrame {
	private JButton btnOk;
	private JButton btnCancel;

	// 메인 윈도우 설정
	public ActionListenerExam() {
		this.setTitle("ActionListenerExam");
		this.setSize(300, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new FlowLayout());
		this.getContentPane().add(getBtnOk());
		this.getContentPane().add(getBtnCancel());
	}

	// ActionListener 타입의 필드 선언 및 익명 객체로 초기화
	private ActionListener actionListner = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnOk) {
				System.out.println("확인 버튼을 클릭했습니다.");
			} else if (e.getSource() == btnCancel) {
				System.out.println("취소 버튼을 클릭했습니다.");
			}
		}
	};

	// Ok 버튼 생성
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton();
			btnOk.setText("확인");
			// actionListner 필드 대입
			btnOk.addActionListener(actionListner);
		}
		return btnOk;
	}
	
	// Cancel 버튼 생성
	private JButton getBtnCancel() {
		if(btnCancel==null) {
			btnCancel = new JButton();
			btnCancel.setText("취소");
			// actionListener 필드 대입
			btnCancel.addActionListener(actionListner);
		}
		return btnCancel;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			ActionListenerExam jFrame = new ActionListenerExam();
			jFrame.setVisible(true);
		});
	}

}
