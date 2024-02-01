package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.BoardDAO;
import model.BoardDTO;

public class BoardApp extends JFrame {
	private BoardApp board;
	private JTable jTable;
	private JPanel pSouth, pNorth;
	private JButton btnInsert, btnSearch, btnReset, btnTruncate;
	private JComboBox<String> cbxFilter;
	private JTextField txtSearch;

	public BoardApp() {
		this.board = this;
		this.setTitle("게시판 리스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(getBoardTable()), BorderLayout.CENTER);
		this.getContentPane().add(getPSouth(), BorderLayout.SOUTH);
		this.getContentPane().add(getPNorth(), BorderLayout.NORTH);
		this.setSize(600, 450);
		locationCenter();
	}

	// 게시글 화면에 표시, 게시판 리프레쉬
	public JTable getBoardTable() {
		// 첫 실행 시 JTable 설정
		if (jTable == null) {
			// jTable 생성
			jTable = new JTable();
			// DefaultTableModel 생성
			final DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
			// 컬럼명 추가
			tableModel.addColumn("번호");
			tableModel.addColumn("제목");
			tableModel.addColumn("글쓴이");
			tableModel.addColumn("날짜");
			tableModel.addColumn("조회수");
			// 인스턴스 가져와서 JTable에 입력
			List<BoardDTO> boardList = BoardDAO.getInstance().getBoards();
			for (int i = 0; i < boardList.size(); i++) {
				BoardDTO board = boardList.get(i);
				Object[] rowData = { board.getBno(), board.getTitle(), board.getWriter(), board.getRegdate(),
						board.getHitcount() };
				tableModel.addRow(rowData);
			}
			// jTable 가운데 정렬
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // DefaultTableCellRenderer 생성
			dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러 가운데 정렬
			TableColumnModel tcm = jTable.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴
			for (int i = 0; i < tcm.getColumnCount(); i++) { // 전체 열에 지정
				tcm.getColumn(i).setCellRenderer(dtcr);
			}
			// jTable column 너비 조절
			jTable.getColumn("번호").setPreferredWidth(5);
			jTable.getColumn("제목").setPreferredWidth(200);
			jTable.getColumn("글쓴이").setPreferredWidth(20);
			jTable.getColumn("날짜").setPreferredWidth(20);
			jTable.getColumn("조회수").setPreferredWidth(5);
			// jTable 컬럼 이동 금지
			jTable.getTableHeader().setReorderingAllowed(false);
			// 컬럼 클릭시 해당 컬럼 기준으로 정렬
			RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
			jTable.setRowSorter(sorter);
			// 열 클릭 시 마우스 이벤트 처리
			jTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int rowIndex = jTable.getSelectedRow();
					if (rowIndex != -1) {
						int bno = (int) jTable.getValueAt(rowIndex, 0);
						jTable.setSelectionBackground(Color.yellow);
						jTable.repaint();
						ViewDialog viewDialog = new ViewDialog(board, bno);
						viewDialog.setVisible(true);
						getBoardTable();
					}
				}
			});
		} else { // 게시판 리프레쉬
			final DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
			// 기존 행 지우기
			tableModel.setNumRows(0);
			// 인스턴스 가져와서 JTable에 입력
			List<BoardDTO> boardList = BoardDAO.getInstance().getBoards();
			for (int i = 0; i < boardList.size(); i++) {
				BoardDTO board = boardList.get(i);
				Object[] rowData = { board.getBno(), board.getTitle(), board.getWriter(), board.getRegdate(),
						board.getHitcount() };
				tableModel.addRow(rowData);
			}
		}
		return jTable;
	}

	// 상부 패널 생성
	public JPanel getPNorth() {
		if (pNorth == null) {
			pNorth = new JPanel();
			pNorth.add(getCbxFilter());
			pNorth.add(getTxtSearch());
			pNorth.add(getBtnSearch());
			pNorth.add(getBtnReset());
		}
		return pNorth;
	}

	// 검색 기준 콤보박스 생성
	public JComboBox<String> getCbxFilter() {
		if (cbxFilter == null) {
			String[] arrString = { "제목", "글쓴이" };
			cbxFilter = new JComboBox<String>(arrString);
			cbxFilter.setBackground(Color.white);
		}
		return cbxFilter;
	}

	// 검색 텍스트 필드 생성
	public JTextField getTxtSearch() {
		if (txtSearch == null) {
			txtSearch = new JTextField(30);
		}
		return txtSearch;
	}

	// 검색 버튼 생성
	public JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton();
			btnSearch.setText("검색");
			btnSearch.addActionListener(e -> {
				String field = (String) cbxFilter.getSelectedItem();
				String word = txtSearch.getText();
				// 제목으로 검색
				if (field.equals("제목")) {
					final DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
					// 기존 행 지우기
					tableModel.setNumRows(0);
					// 인스턴스 가져와서 JTable에 입력
					List<BoardDTO> boardList = BoardDAO.getInstance().getBoards();
					for (int i = 0; i < boardList.size(); i++) {
						BoardDTO board = boardList.get(i);
						if (board.getTitle().contains(word)) {
							Object[] rowData = { board.getBno(), board.getTitle(), board.getWriter(),
									board.getRegdate(), board.getHitcount() };
							tableModel.addRow(rowData);
						}
					}
				}
				// 글쓴이로 검색
				else if (field.equals("글쓴이")) {
					final DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
					// 기존 행 지우기
					tableModel.setNumRows(0);
					// 인스턴스 가져와서 JTable에 입력
					List<BoardDTO> boardList = BoardDAO.getInstance().getBoards();
					for (int i = 0; i < boardList.size(); i++) {
						BoardDTO board = boardList.get(i);
						if (board.getWriter().contains(word)) {
							Object[] rowData = { board.getBno(), board.getTitle(), board.getWriter(),
									board.getRegdate(), board.getHitcount() };
							tableModel.addRow(rowData);
						}
					}
				}
			});
		}
		return btnSearch;
	}

	// 검색 초기화 버튼 생성
	public JButton getBtnReset() {
		if (btnReset == null) {
			btnReset = new JButton();
			btnReset.setText("초기화");
			btnReset.addActionListener(e -> {
				// 검색 조건과 텍스트 필드 초기화
				txtSearch.setText("");
				cbxFilter.setSelectedItem("제목");
				getBoardTable();
			});
		}
		return btnReset;
	}

	// 하부 패널 생성, 버튼 부착
	public JPanel getPSouth() {
		if (pSouth == null) {
			pSouth = new JPanel();
			pSouth.add(getBtnInsert());
			pSouth.add(getBtnTruncate());
		}
		return pSouth;
	}

	// 추가 버튼
	public JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton();
			btnInsert.setText("추가");
			// 추가 버튼 클릭 시 이벤트 처리
			btnInsert.addActionListener(e -> {
				InsertDialog insertDialog = new InsertDialog(board);
				insertDialog.setVisible(true);
				getBoardTable();
			});
		}
		return btnInsert;
	}

	// 게시글 전체 삭제 버튼
	public JButton getBtnTruncate() {
		if (btnTruncate == null) {
			btnTruncate = new JButton();
			btnTruncate.setText("전체 삭제");
			btnTruncate.addActionListener(e -> {
				// 버튼 클릭시 이벤트 처리
				BoardDAO.getInstance().truncateBoard();
				getBoardTable();
			});
		}
		return btnTruncate;
	}

	// 화면 가운데로 위치 설정
	private void locationCenter() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int leftTopX = centerPoint.x - this.getWidth() / 2;
		int leftTopY = centerPoint.y - this.getHeight() / 2;
		this.setLocation(leftTopX, leftTopY);
	}

	// 메인문
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			BoardApp board = new BoardApp();
			board.setVisible(true);
		});
	}
}
