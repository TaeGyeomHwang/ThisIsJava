package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import model.BoardDAO;
import model.BoardDTO;

public class BoardApp extends JFrame {
	private BoardApp board;
	private JTable jTable;
	private JPanel searchPanel, pSouth;
	private JComboBox<String> searchKind;
	private JTextField searchInput;
	private JButton initBtn, btnInsert;
	
	public BoardApp() {
		this.board = this;
		this.setTitle("게시판 리스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(getSearchPanel(), BorderLayout.NORTH);
		this.getContentPane().add(new JScrollPane(getBoardTable()), BorderLayout.CENTER);
		this.getContentPane().add(getPSouth(), BorderLayout.SOUTH);
		this.setSize(600, 450);
		locationCenter();
	}
	
	private JPanel getSearchPanel() {
		if(searchPanel==null) {
			searchPanel = new JPanel();
			searchPanel.add(getSearchKind());
			searchPanel.add(getSearchBar());
			searchPanel.add(getInitBtn());
		}
		return searchPanel;
	}
	
	private JComboBox<String> getSearchKind() {
		if(searchKind==null) {
			searchKind = new JComboBox<String>(new String[] {"title", "writer"});
			searchKind.addActionListener(new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e) {
					String kind = searchKind.getSelectedItem().toString();
					searchKeyword(kind, searchInput.getText());
				}
			});
		}
		return searchKind;
	}
	
	private JTextField getSearchBar() {
		if(searchInput == null) {
			searchInput = new JTextField(15);
			searchInput.addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {//문자 키를 눌렀을 때
				}
				@Override
				public void keyReleased(KeyEvent e) {
					//키를 떼었을 때
					String kind = searchKind.getSelectedItem().toString();
					searchKeyword(kind, searchInput.getText());
				}
				@Override
				public void keyPressed(KeyEvent e) {//키를 눌렀을 때
				}
			});
		}
		return searchInput;
	}
	
	public JButton getInitBtn() {
		if(initBtn==null) {
			initBtn = new JButton();
			initBtn.setText("초기화");
			initBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					refreshBoard();
				}
			});
		}
		return initBtn;
	}
	
	public JTable getBoardTable() {
		if(jTable == null) {
			jTable = new JTable();
			//칼럼별 자동 정렬
			jTable.setAutoCreateRowSorter(true);
			
			DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
			tableModel.addColumn("번호");
			tableModel.addColumn("제목");
			tableModel.addColumn("글쓴이");
			tableModel.addColumn("날짜");
			tableModel.addColumn("조회수");
			refreshBoard();
			
			jTable.getColumn("번호").setPreferredWidth(20);
			jTable.getColumn("제목").setPreferredWidth(250);
			jTable.getColumn("글쓴이").setPreferredWidth(50);
			jTable.getColumn("날짜").setPreferredWidth(50);
			jTable.getColumn("조회수").setPreferredWidth(20);
			
			CenterTableCellRenderer ctcr = new CenterTableCellRenderer();
			jTable.getColumn("번호").setCellRenderer(ctcr);
			jTable.getColumn("제목").setCellRenderer(ctcr);
			jTable.getColumn("글쓴이").setCellRenderer(ctcr);
			jTable.getColumn("날짜").setCellRenderer(ctcr);
			jTable.getColumn("조회수").setCellRenderer(ctcr);
			
			jTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int rowIndex = jTable.getSelectedRow();
					if(rowIndex !=-1) {
						int bno = (int)jTable.getValueAt(rowIndex, 0);
						ViewDialog viewDialog = new ViewDialog(board, bno);
						viewDialog.setVisible(true);
					}
				}		
			});
		}
		return jTable;
	}
	
	public class CenterTableCellRenderer extends JLabel implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			setText(value.toString());
			setFont(new Font(null, Font.PLAIN, 12));
			setHorizontalAlignment(JLabel.CENTER);
			setOpaque(true);
			if(isSelected) { setBackground(Color.YELLOW); } 
			else { setBackground(Color.WHITE); }
			return this;
		}
	}	
	
	public JPanel getPSouth() {
		if(pSouth == null) {
			pSouth = new JPanel();
			pSouth.add(getBtnInsert());
		}
		return pSouth;
	}

	public JButton getBtnInsert() {
		if(btnInsert == null) {
			btnInsert = new JButton();
			btnInsert.setText("추가");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InsertDialog insertDialog = new InsertDialog(board);
					insertDialog.setVisible(true);
				}
			});
		}
		return btnInsert;
	}
	
	public void searchKeyword(String kind, String keyword) {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setNumRows(0);
		for(BoardDTO dto : BoardDAO.getInstance().searchKeyword(kind, keyword)) {
			Object[] rowData = { dto.getBno(), dto.getTitle(), dto.getWriter(), dto.getRegdate(), dto.getHitcount() };
			tableModel.addRow(rowData);
		}
	}
	
	public void refreshBoard() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setNumRows(0);
		for(BoardDTO dto : BoardDAO.getInstance().getBoards()) {
			Object[] rowData = { dto.getBno(), dto.getTitle(), dto.getWriter(), dto.getRegdate(), dto.getHitcount() };
			tableModel.addRow(rowData);
		}
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
