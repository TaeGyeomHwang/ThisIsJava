package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	public JPanel getPCenter() {
		if(pCenter==null) {
			/*코드 추가*/
		}
		return pCenter;
	}
	
	public JPanel getPTitle() {
		if(pTitle==null) {
			/*코드 추가*/
		}
		return pTitle;
	}	
	
	public JPanel getPWriter() {
		if(pWriter==null) {
			/*코드 추가*/
		}
		return pWriter;
	}		
	
	public JPanel getPContent() {
		if(pContent == null) {
			/*코드 추가*/
		}
		return pContent;
	}

	public JPanel getPSouth() {
		if(pSouth == null) {
			/*코드 추가*/
		}
		return pSouth;
	}
	
	public void setBoard() {
		/*코드 추가*/
	}
	
	public JButton getBtnUpdate() {
		if(btnUpdate == null) {
			/*코드 추가*/
		}
		return btnUpdate;
	}
	
	public JButton getBtnDelete() {
		if(btnDelete == null) {
			/*코드 추가*/
		}
		return btnDelete;
	}	
	
	public JButton getBtnClose() {
		if(btnClose == null) {
			/*코드 추가*/
		}
		return btnClose;
	}	
}



