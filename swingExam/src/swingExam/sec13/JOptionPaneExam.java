package swingExam.sec13;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class JOptionPaneExam extends JFrame {
	private JButton btnMessage, btnConfirm;
	private JButton btnInput, btnOption;

	public JOptionPaneExam() {
		this.setTitle("JOptionPaneExam");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(4, 1));
		this.getContentPane().add(getBtnMessage());
		this.getContentPane().add(getBtnConfirm());
		this.getContentPane().add(getBtnInput());
		this.getContentPane().add(getBtnOption());
		this.setSize(500, 300);
	}

	public JButton getBtnMessage() {
		if (btnMessage == null) {
			btnMessage = new JButton();
			btnMessage.setText("MessageDialog");
			btnMessage.addActionListener(e -> {
				JOptionPane.showMessageDialog(JOptionPaneExam.this, "다이얼로그 텍스트 내용", "INFORMATION_MESSAGE",
						JOptionPane.INFORMATION_MESSAGE);

			});
		}
		return btnMessage;
	}

	public JButton getBtnConfirm() {
		if (btnConfirm == null) {
			btnConfirm = new JButton();
			btnConfirm.setText("ConfirmDialog");
			btnConfirm.addActionListener(e -> {
				int option = JOptionPane.showConfirmDialog(JOptionPaneExam.this, "다이얼로그 텍스트 내용", "OK_CANCEL_OPTION",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
				if (option == JOptionPane.OK_OPTION) {
					System.out.println("확인 버튼을 눌렀군요");
				} else if (option == JOptionPane.CANCEL_OPTION) {
					System.out.println("취소 버튼을 눌렀군요");
				} else if (option == JOptionPane.CLOSED_OPTION) {
					System.out.println("닫기 버튼을 눌렀군요");
				}
			});
		}
		return btnConfirm;
	}

	public JButton getBtnInput() {
		if (btnInput == null) {
			btnInput = new JButton();
			btnInput.setText("InputDialog");
			btnInput.addActionListener(e -> {
				String input = null;
				input = JOptionPane.showInputDialog(JOptionPaneExam.this, "다이얼로그 텍스트 내용", "InputDialog",
						JOptionPane.INFORMATION_MESSAGE);
				System.out.println("입력된 텍스트: " + input);

				input = (String) JOptionPane.showInputDialog(JOptionPaneExam.this, "다이얼로그 텍스트 내용", "InputDialog",
						JOptionPane.PLAIN_MESSAGE, null, new String[] { "Java", "JDBC", "JSP", "Spring" }, "JDBC");
				System.out.println("선택된 항목: " + input);
			});
		}
		return btnInput;
	}

	public JButton getBtnOption() {
		if (btnOption == null) {
			btnOption = new JButton();
			btnOption.setText("OptionDialog");
			btnOption.addActionListener(e -> {
				int option = JOptionPane.showOptionDialog(JOptionPaneExam.this, "다이얼로그 텍스트 내용", "OptionDialog",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] { "시작", "종료" },
						"시작");
				if (option == 0) {
					System.out.println("시작 버튼을 눌렀군요");
				} else if (option == 1) {
					System.out.println("종료 버튼을 눌렀군요");
				}
			});
		}
		return btnOption;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			JOptionPaneExam jFrame = new JOptionPaneExam();
			jFrame.setVisible(true);
		});
	}

}
