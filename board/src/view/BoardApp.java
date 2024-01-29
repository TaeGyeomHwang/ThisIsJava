package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import model.BoardDAO;
import model.BoardDTO;

public class BoardApp extends JFrame {
	private BoardApp board;
	private JTable jTable;
	private JPanel pSouth;
	private JButton btnInsert;
	
	public BoardApp() {
		this.board = this;
		this.setTitle("게시판 리스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(getBoardTable()), BorderLayout.CENTER);
		this.getContentPane().add(getPSouth(), BorderLayout.SOUTH);
		this.setSize(600, 450);
		locationCenter();
	}
	
	public JTable getBoardTable() {
		if(jTable == null) {
			jTable = new JTable();
			/*코드 추가*/
		}
		return jTable;
	}
	
	public JPanel getPSouth() {
		if(pSouth == null) {
			/*코드 추가*/
		}
		return pSouth;
	}

	public JButton getBtnInsert() {
		if(btnInsert == null) {
			/*코드 추가*/
		}
		return btnInsert;
	}
	
	private void locationCenter() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int leftTopX = centerPoint.x - this.getWidth()/2;
		int leftTopY = centerPoint.y - this.getHeight()/2;
		this.setLocation(leftTopX, leftTopY);
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
        	BoardApp board = new BoardApp();
        	board.setVisible(true);
	    });
	}	
}
