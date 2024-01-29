package swingExam.sec09;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

public class JTableExam4 extends JFrame {

	private JTable jTable;
	private JPanel pSouth;
	private JTextField txtName;
	private JTextField txtAge;
	private Object[][] rowData;

	public JTableExam4() {
		this.setTitle("JTableExam");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(getJTable()), BorderLayout.CENTER);
		this.getContentPane().add(getPSouth(), BorderLayout.SOUTH);
		this.setSize(200, 230);
	}

	public JTable getJTable() {
		if (jTable == null) {
			String[] columnNames = new String[] { "이름", "나이" };
			rowData = new Object[][] { { "춘삼월", 25 }, { "하여름", 23 }, { "추가을", 22 }, { "동겨울", 27 } };
			jTable = new JTable(rowData, columnNames);

			jTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int rowIndex = jTable.getSelectedRow();
					if (rowIndex != -1) {
						TableModel tableModel = jTable.getModel();
						String name = (String) tableModel.getValueAt(rowIndex, 0);
						Integer age = (Integer) tableModel.getValueAt(rowIndex, 1);
						getTxtName().setText(name);
						getTxtAge().setText(String.valueOf(age.intValue()));
					}
				}
			});
		}
		return jTable;
	}
	
	public JPanel getPSouth() {
		if(pSouth==null) {
			pSouth = new JPanel();
			pSouth.setLayout(new GridLayout(4,2));
			pSouth.add(new JLabel("[선택한 행 정보]"));
			pSouth.add(new JLabel(""));
			pSouth.add(new JLabel("이름",JLabel.CENTER));
			pSouth.add(getTxtName());
			pSouth.add(new JLabel("나이",JLabel.CENTER));
			pSouth.add(getTxtAge());
		}
		return pSouth;
	}
	
	public JTextField getTxtName() {
		if(txtName==null) {
			txtName = new JTextField();
		}
		return txtName;
	}
	public JTextField getTxtAge() {
		if(txtAge==null) {
			txtAge = new JTextField();
		}
		return txtAge;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			JTableExam4 jFrame = new JTableExam4();
			jFrame.setVisible(true);
		});
	}

}
