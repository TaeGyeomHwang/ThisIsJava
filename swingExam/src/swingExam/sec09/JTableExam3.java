package swingExam.sec09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class JTableExam3 extends JFrame {

	private JTable jTable;

	public JTableExam3() {
		this.setTitle("JTableExam");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(getJTable()), BorderLayout.CENTER);
		this.setSize(200, 125);
	}

	public JTable getJTable() {
		if (jTable == null) {
			String[] columnNames = { "이름", "나이", "선택" };
			Object[][] rowData = { { "춘삼월", 25, false }, { "하여름", 26, true }, { "추가을", 22, false },
					{ "동겨울", 27, true } };
			jTable = new JTable(rowData, columnNames);

			TableColumn tcName = jTable.getColumn("이름");
			tcName.setCellRenderer(new NameTableCellRenderer());
			TableColumn tcAge = jTable.getColumn("나이");
			tcAge.setCellRenderer(new AgeTableCellRenderer());
			TableColumn tcSelect = jTable.getColumn("선택");
			tcSelect.setCellRenderer(new SelectTableCellRenderer());
		}
		return jTable;
	}

	public class NameTableCellRenderer extends JLabel implements TableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText(value.toString());
			setFont(new Font(null, Font.PLAIN, 12));
			setHorizontalAlignment(JLabel.CENTER);
			setOpaque(true);
			if (isSelected) {
				setBackground(Color.YELLOW);
			} else {
				setBackground(Color.white);
			}
			return this;
		}
	}

	public class AgeTableCellRenderer extends JLabel implements TableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			int age = ((Integer) value).intValue();
			if (age <= 25) {
				setIcon(new ImageIcon(getClass().getResource("../image2.jpg")));
			} else {
				setIcon(new ImageIcon(getClass().getResource("../image3.jpg")));
			}
			setText(value.toString());
			setFont(new Font(null, Font.PLAIN, 12));
			setHorizontalAlignment(JLabel.CENTER);
			setOpaque(true);
			if (isSelected) {
				setBackground(Color.yellow);
			} else {
				setBackground(Color.white);
			}
			return this;
		}
	}

	public class SelectTableCellRenderer extends JCheckBox implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Boolean boolWraper = (Boolean) value;
			setSelected(boolWraper.booleanValue());
			setHorizontalAlignment(CENTER);
			if (isSelected) {
				setBackground(Color.yellow);
			} else {
				setBackground(Color.white);
			}
			return this;
		}

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JTableExam3 jFrame = new JTableExam3();
			jFrame.setVisible(true);
		});
	}

}
