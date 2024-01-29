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
		
		this.setLocation(
			boardApp.getLocationOnScreen().x + (boardApp.getWidth()-this.getWidth())/2,
			boardApp.getLocationOnScreen().y + (boardApp.getHeight()-this.getHeight())/2
		);
		
		this.getContentPane().add(getPCenter(), BorderLayout.CENTER);
		this.getContentPane().add(getPSouth(), BorderLayout.SOUTH);
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
	
	public JButton getBtnOk() {
		if(btnOk == null) {
			/*코드 추가*/
		}
		return btnOk;
	}
	
	public JButton getBtnCancel() {
		if(btnCancel == null) {
			/*코드 추가*/
		}
		return btnCancel;
	}	
}


