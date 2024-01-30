package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import model.BoardDAO;
import model.BoardDTO;

public class ViewDialog extends JDialog {
	private BoardApp boardApp;
	private JPanel pCenter, pTitle, pContent, pWriter, pSouth;
	private JTextField txtTitle, txtWriter;
	private JTextArea txtContent;
	private JButton btnUpdate, btnDelete, btnClose;
	private int bno;
	
	public ViewDialog(BoardApp boardApp, int bno) {
		this.boardApp = boardApp;
		this.bno = bno;
		this.setTitle("게시물 보기");					
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setResizable(false);	
		this.setModal(true);
		this.setSize(400, 270);
		
		this.setLocation(
			boardApp.getLocationOnScreen().x + (boardApp.getWidth()-this.getWidth())/2,
			boardApp.getLocationOnScreen().y + (boardApp.getHeight()-this.getHeight())/2
		);
		
		this.getContentPane().add(getPCenter(), BorderLayout.CENTER);
		this.getContentPane().add(getPSouth(), BorderLayout.SOUTH);
		this.setBoard();
	}
	//텍스트 필드 부착 패널 생성
	public JPanel getPCenter() {
		if(pCenter==null) {
			pCenter = new JPanel();
			pCenter.add(getPTitle());
			pCenter.add(getPWriter());
			pCenter.add(getPContent());
		}
		return pCenter;
	}
	//제목 패널, 텍스트 필드 생성
	public JPanel getPTitle() {
		if(pTitle==null) {
			pTitle = new JPanel();
			JLabel label = new JLabel("제목");
			label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
			pTitle.add(label);
			BoardDTO board = BoardDAO.getInstance().getBoardByBno(bno);
			if (txtTitle == null) {
				txtTitle = new JTextField(30);
				txtTitle.setText(board.getTitle());
			}
			pTitle.add(txtTitle);
		}
		return pTitle;
	}	
	//글쓴이 패널, 텍스트 필드 생성
	public JPanel getPWriter() {
		if(pWriter==null) {
			pWriter = new JPanel();
			JLabel label = new JLabel("글쓴이");
			pWriter.add(label);
			BoardDTO board = BoardDAO.getInstance().getBoardByBno(bno);
			if (txtWriter == null) {
				txtWriter = new JTextField(30);
				txtWriter.setText(board.getWriter());;
			}
			pWriter.add(txtWriter);
		}
		return pWriter;
	}		
	//내용 패널, 텍스트 필드 생성
	public JPanel getPContent() {
		if(pContent == null) {
			pContent = new JPanel();
			JLabel label = new JLabel("내용");
			label.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 10));
			pContent.add(label);
			BoardDTO board = BoardDAO.getInstance().getBoardByBno(bno);
			if (txtContent == null) {
				txtContent = new JTextArea(10, 30);
				txtContent.setText(board.getContent());
			}
			pContent.add(txtContent);
		}
		return pContent;
	}
	//버튼 부착 패널 생성
	public JPanel getPSouth() {
		if(pSouth == null) {
			pSouth = new JPanel();
			pSouth.add(getBtnUpdate());
			pSouth.add(getBtnDelete());
			pSouth.add(getBtnClose());
		}
		return pSouth;
	}
	//다이얼로그 활성화 시 조회수 증가
	public void setBoard() {
		BoardDTO board = BoardDAO.getInstance().getBoardByBno(bno);
		int hitcount = board.getHitcount()+1;
		BoardDAO.getInstance().addHitcount(hitcount, bno);
	}
	//수정 버튼 생성
	public JButton getBtnUpdate() {
		if(btnUpdate == null) {
			btnUpdate = new JButton();
			btnUpdate.setText("수정");
			btnUpdate.addActionListener(e->{
				BoardDTO board = new BoardDTO();
				board.setTitle(txtTitle.getText());
				board.setWriter(txtWriter.getText());
				board.setContent(txtContent.getText());
				BoardDAO.getInstance().updateBoard(board, bno);
				dispose();
			});
		}
		return btnUpdate;
	}
	//삭제 버튼 생성
	public JButton getBtnDelete() {
		if(btnDelete == null) {
			btnDelete = new JButton();
			btnDelete.setText("삭제");
			btnDelete.addActionListener(e->{
				BoardDAO.getInstance().deleteBoard(bno);
				dispose();
			});
		}
		return btnDelete;
	}	
	//닫기 버튼 생성
	public JButton getBtnClose() {
		if(btnClose == null) {
			btnClose = new JButton();
			btnClose.setText("닫기");
			btnClose.addActionListener(e->{
				dispose();
			});
		}
		return btnClose;
	}	
}



