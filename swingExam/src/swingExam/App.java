package swingExam;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App extends JFrame {

	public App() {
		setTitle("처음 만든 윈도우"); // 제목
		setSize(300, 100); // 윈도우 크기
		add(new JButton("OK"), BorderLayout.SOUTH); // button 추가
		addWindowListener(new WindowAdapter() { // 종료 버튼을 클릭하면 프로세스 종료
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			App app = new App(); // 윈도우 생성
			app.setVisible(true); // 윈도우를 보여줌
		});

	}

}
