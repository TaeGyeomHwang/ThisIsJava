package swingExam;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class JWindowExam extends JWindow {

	public JWindowExam() {
		// JWindow의 크기
		this.setSize(600, 350);
		// JWindow를 화면 중앙에 띄우기
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int leftTopX = centerPoint.x - getWidth() / 2;
		int leftTopY = centerPoint.y - getHeight() / 2;
		this.setLocation(leftTopX, leftTopY);
		// 마우스 클릭 이벤트 처리
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JWindowExam jWindow = new JWindowExam();
				jWindow.setVisible(true);
			}
		});
	}

}
