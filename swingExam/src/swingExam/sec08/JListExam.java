package swingExam.sec08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class JListExam extends JFrame {

	private JPanel pWest;
	private JList listString;
	private JList listImage;
	private JLabel jLabel;

	// 메인 윈도우 설정
	public JListExam() {
		this.setTitle("JListExam");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250, 200);
		this.getContentPane().setBackground(Color.white);
		this.getContentPane().add(getPWest(), BorderLayout.WEST);
		this.getContentPane().add(getJLabel(), BorderLayout.CENTER);
	}

	// 좌측 목록 JPanel 생성
	public JPanel getPWest() {
		if (pWest == null) {
			pWest = new JPanel();
			pWest.setLayout(new GridLayout(2, 1));
			pWest.add(new JScrollPane(getListString()));
			pWest.add(new JScrollPane(getListImage()));
		}
		return pWest;
	}

	// 텍스트 목록을 갖는 JList 생성
	public JList getListString() {
		if (listString == null) {
			String[] items = { "Bass1", "Bass2", "Bass3" };
			listString = new JList(items);
			listString.addListSelectionListener(e -> {
				if (!e.getValueIsAdjusting()) {
					int selectedIndex = listString.getSelectedIndex();
					ImageIcon image = new ImageIcon(getClass().getResource("../image" + (selectedIndex + 1) + ".jpg"));
					getJLabel().setIcon(image);
				}
			});
		}
		return listString;
	}

	// 이미지 목록을 갖는 JList 생성
	public JList getListImage() {
		if (listImage == null) {
			Vector items = new Vector();
			for (int i = 1; i < 4; i++) {
				ImageIcon image = new ImageIcon(getClass().getResource("../image" + i + ".jpg"));
				items.addElement(image);
			}
			listImage = new JList(items);
			listImage.addListSelectionListener(e -> {
				if (!e.getValueIsAdjusting()) {
					ImageIcon image = (ImageIcon) listImage.getSelectedValue();
					getJLabel().setIcon(image);
				}
			});
		}
		return listImage;
	}

	// 선택한 항목의 이미지를 보여주는 JLabel 생성
	public JLabel getJLabel() {
		if (jLabel == null) {
			jLabel = new JLabel();
			jLabel.setHorizontalAlignment(JLabel.CENTER);
		}
		return jLabel;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JListExam jFrame = new JListExam();
			jFrame.setVisible(true);
		});
	}

}