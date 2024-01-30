package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import model.BoardDAO;
import model.BoardDTO;

public class InsertDialog extends JDialog {
	private BoardApp boardApp;
	private JPanel pCenter, pTitle, pContent, pWriter, pSouth;
	private JTextField txtTitle, txtWriter;
	private JTextArea txtContent;
	private JButton btnOk, btnCancel;

	public InsertDialog(BoardApp boardApp) {
		this.boardApp = boardApp;
		this.setTitle("게시물 작성");
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setSize(400, 270);

		this.setLocation(boardApp.getLocationOnScreen().x + (boardApp.getWidth() - this.getWidth()) / 2,
				boardApp.getLocationOnScreen().y + (boardApp.getHeight() - this.getHeight()) / 2);

		this.getContentPane().add(getPCenter(), BorderLayout.CENTER);
		this.getContentPane().add(getPSouth(), BorderLayout.SOUTH);
	}
	//텍스트 필드 부착 패널 생성
	public JPanel getPCenter() {
		if (pCenter == null) {
			pCenter = new JPanel();
			pCenter.add(getPTitle());
			pCenter.add(getPWriter());
			pCenter.add(getPContent());
		}
		return pCenter;
	}
	//제목 패널, 텍스트 필드 생성
	public JPanel getPTitle() {
		if (pTitle == null) {
			pTitle = new JPanel();
			JLabel label = new JLabel("제목");
			label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
			pTitle.add(label);
			if (txtTitle == null) {
				txtTitle = new JTextField(30);
			}
			pTitle.add(txtTitle);

		}
		return pTitle;
	}
	//글쓴이 패널, 텍스트 필드 생성
	public JPanel getPWriter() {
		if (pWriter == null) {
			pWriter = new JPanel();
			JLabel label = new JLabel("글쓴이");
			pWriter.add(label);
			if (txtWriter == null) {
				txtWriter = new JTextField(30);
			}
			pWriter.add(txtWriter);
		}
		return pWriter;
	}
	//내용 패널, 텍스트 필드 생성
	public JPanel getPContent() {
		if (pContent == null) {
			pContent = new JPanel();
			JLabel label = new JLabel("내용");
			label.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 10));
			pContent.add(label);
			if (txtContent == null) {
				txtContent = new JTextArea(10, 30);
			}
			pContent.add(txtContent);
		}
		return pContent;
	}
	//버튼 부착 패널 생성
	public JPanel getPSouth() {
		if (pSouth == null) {
			pSouth = new JPanel();
			pSouth.add(getBtnOk());
			pSouth.add(getBtnCancel());
		}
		return pSouth;
	}

	//저장 버튼 생성
	public JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton();
			btnOk.setText("저장");
			btnOk.addActionListener(e->{
				BoardDTO board = new BoardDTO();
				board.setTitle(txtTitle.getText());
				board.setWriter(txtWriter.getText());
				board.setContent(txtContent.getText());
				BoardDAO.getInstance().insertBoard(board);
				dispose();
			});
		}
		return btnOk;
	}

	//취소 버튼 생성
	public JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton();
			btnCancel.setText("취소");
			btnCancel.addActionListener(e->{
				dispose();
			});
		}
		return btnCancel;
	}

}
