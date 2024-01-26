package swingExam.sec05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ClosableExam1 extends JFrame {
	private JButton btnClose;

	// 메인 윈도우 설정
	public ClosableExam1() {
		this.setTitle("CloseExam");
		this.setSize(300, 100);
		this.setLayout(new FlowLayout());
		this.getContentPane().add(getBtnClose());

		// WindowListner 추가
		this.addWindowListener(new MyWindowAdapter());
	}
	
	private JButton getBtnClose() {
		if(btnClose == null) {
			btnClose = new JButton();
			btnClose.setText("닫기");
			
			// ActionListner 추가
			btnClose.addActionListener(new MyActionListner());
		}
		return btnClose;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			ClosableExam1 jFrame = new ClosableExam1();
			jFrame.setVisible(true);
		});
	}
}

// WindowAdapter 클래스를 상속해서 WindowListner 클래스 작성
class MyWindowAdapter extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

// ActionListner를 구현해서 ActionListner 클래스 작성
class MyActionListner implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
