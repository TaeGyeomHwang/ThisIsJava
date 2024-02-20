package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import model.BlockDAO;
import model.BlockDTO;

public class BlockDialogDelete extends JDialog {
	private JTable table;
	private int rowIndex = -1;
	private String id = Login.getLoginedId();

	public BlockDialogDelete(Frame parent) {
		super(parent, "블록 삭제하기", true);
		
		// 삭제하기 버튼
		JButton deleteButton = new JButton("삭제하기");
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteBlock();
			}
		});

		// 취소하기 버튼
		JButton cancelButton = new JButton("취소하기");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// 블록 목록 표시할 테이블 생성
		table = new JTable();
		// DefaultTableModel 생성, 테이블에 값 입력
		final DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.addColumn("제목");
		BlockDAO blockDAO = BlockDAO.getInstance();
		List<BlockDTO> blocks = blockDAO.getBlockById(id);
		StringBuilder sb = new StringBuilder();
		for (BlockDTO block : blocks) {
			Object[] rowData = { block.getBlockTitle() };
			tableModel.addRow(rowData);
		}
		// 사이즈 조절
		resizeColumnWidth(table);
		// 컬럼 선택 시 마우스 이벤트
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rowIndex = table.getSelectedRow();
				if (rowIndex != -1) {
					table.setSelectionBackground(new Color(170, 207,243));
					table.repaint();
				}
			}
		});
		
		// "제목" 컬럼명에 커스텀 렌더러 설정
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
	        @Override
	        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	            
	            // 배경색 설정
	            if (value != null && "제목".equals(value.toString())) {
	                component.setBackground(new Color(230, 230, 230)); 
	                ((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);
	            } else {
	                component.setBackground(table.getTableHeader().getBackground());
	            }
	            
	            return component;
	        }
	    };
	    table.getColumnModel().getColumn(0).setHeaderRenderer(headerRenderer);
	    table.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    table.setPreferredScrollableViewportSize(new Dimension(400, 300));
	    table.setDefaultEditor(Object.class, null);
	    resizeColumnWidth(table);

		JPanel titlePanel = new JPanel();
		titlePanel.add(new JLabel("삭제할 블록 문제를 선택해주세요 :"));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200)); // 세로 크기 조절
		JPanel tablePanel = new JPanel(new BorderLayout());
		tablePanel.add(scrollPane, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(deleteButton);
		buttonPanel.add(cancelButton);

		JPanel panel = new JPanel();
		panel.add(titlePanel, BorderLayout.NORTH);
		panel.add(tablePanel, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		panel.setPreferredSize(new Dimension(550, 300));
		
		titlePanel.setBackground(new Color(170, 207,243));
		tablePanel.setBackground(new Color(170, 207,243));
		buttonPanel.setBackground(new Color(170, 207,243));
		panel.setBackground(new Color(170, 207,243));

		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(parent);
		
		// ESC 입력시 창 닫기
		table.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode== KeyEvent.VK_ESCAPE) {
					dispose();
				}
				if (keyCode == KeyEvent.VK_ENTER){
					deleteButton.doClick();
				}
			}
		});
	}

	// DB에 블록 문제 삭제
	private void deleteBlock() {
		if (rowIndex != -1) {
			String title = (String) table.getValueAt(rowIndex, 0);
			BlockDAO blockDAO = BlockDAO.getInstance();
			blockDAO.deleteBoard(id, title);
			// 팝업 출력
			JOptionPane.showMessageDialog(this, "블록 문제를 삭제했습니다");
			// 테이블, 텍스트에리어 초기화
			refreshTable();
			((BlockExercise) getParent()).refreshTextArea();
		} else {
			// 팝업 출력
			JOptionPane.showMessageDialog(this, "블록 문제를 선택해주세요.");
		}
	}

	// JTable에서 컬럼 size 내용길이에 맞춰 조절
	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 50; // 최소 width
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}
	
	// 테이블 초기화
	private void refreshTable() {
		final DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		// 기존 테이블 지우기
		tableModel.setNumRows(0);
		// 테이블 리프레쉬
		BlockDAO blockDAO = BlockDAO.getInstance();
		List<BlockDTO> blocks = blockDAO.getBlockById(id);
		for (BlockDTO block : blocks) {
			Object[] rowData = { block.getBlockTitle() };
			tableModel.addRow(rowData);
		}
	}
	
}