package swingExam.sec13;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JFileChooserExam extends JFrame {
	private JButton btnFileOpen, btnFileSave;

	public JFileChooserExam() {
		this.setTitle("JFileChooserExam");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(2, 1));
		this.getContentPane().add(getBtnFileOpen());
		this.getContentPane().add(getBtnFileSave());
		this.setSize(150, 100);
	}

	public JButton getBtnFileOpen() {
		if (btnFileOpen == null) {
			btnFileOpen = new JButton();
			btnFileOpen.setText("File Open");
			btnFileOpen.addActionListener(e -> {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.addChoosableFileFilter(
						new FileNameExtensionFilter("그림파일(*.jpg, *.gif, *.bmp)", "jpg", "gif", "bmp"));
				jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("텍스트 파일(*.txt)", "txt"));
				int option = jFileChooser.showOpenDialog(JFileChooserExam.this);
				if (option == jFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					System.out.println("열어야 할 파일 절대경로: " + file.getAbsolutePath());
					System.out.println("열어야 할 파일 이름: " + file.getName());
				} else if (option == jFileChooser.CANCEL_OPTION) {
					System.out.println("취소 또는 닫기를 눌렀군요");
				}
			});
		}
		return btnFileOpen;
	}

	public JButton getBtnFileSave() {
		if (btnFileSave == null) {
			btnFileSave = new JButton();
			btnFileSave.setText("File Save");
			btnFileSave.addActionListener(e -> {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.addChoosableFileFilter(
						new FileNameExtensionFilter("그림파일(*.jpg, *.gif, *.bmp)", "jpg", "gif", "bmp"));
				jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("텍스트 파일(*.txt)", "txt"));
				int option = jFileChooser.showOpenDialog(JFileChooserExam.this);
				if (option == jFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					System.out.println("저장할 파일: " + file.getAbsolutePath());
				} else if (option == jFileChooser.CANCEL_OPTION) {
					System.out.println("취소 또는 닫기를 눌렀군요");
				}
			});
		}
		return btnFileSave;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			JFileChooserExam jFrame = new JFileChooserExam();
			jFrame.setVisible(true);
		});
	}

}
