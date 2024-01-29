package swingExam.sec11;

import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class JMenuExam2 extends JFrame {

	private JMenuBar jMenuBar;
	private JMenu menuFile;
	private JMenuItem menuItemSave, menuItemExit;

	public JMenuExam2() {
		this.setTitle("JMenuExam");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(getJMenuBar());
		this.setSize(300, 200);
	}

	public JMenuBar getJMenuBar() {
		if (jMenuBar == null) {
			jMenuBar = new JMenuBar();
			jMenuBar.add(getMenuFile());
		}
		return jMenuBar;
	}

	public JMenu getMenuFile() {
		if (menuFile == null) {
			menuFile = new JMenu("파일");
			menuFile.add(getMenuItemSave());
			menuFile.add(getMenuItemExit());
		}
		return menuFile;
	}

	public JMenuItem getMenuItemSave() {
		if (menuItemSave == null) {
			menuItemSave = new JCheckBoxMenuItem("파일 저장");
			menuItemSave.addActionListener(actionListener);
		}
		return menuItemSave;
	}

	public JMenuItem getMenuItemExit() {
		if (menuItemExit == null) {
			menuItemExit = new JMenuItem("종료");
			menuItemExit.addActionListener(actionListener);
		}
		return menuItemExit;
	}

	private ActionListener actionListener = e -> {
		if (e.getSource() == menuItemSave) {
			if (menuItemSave.isSelected()) {
				JOptionPane.showMessageDialog(JMenuExam2.this, "해제 상태 >> 체크 상태.");
			} else {
				JOptionPane.showMessageDialog(JMenuExam2.this, "체크 상태 >> 해제 상태.");
			}
		} else if (e.getSource() == menuItemExit) {
			System.exit(0);
		}
	};

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			JMenuExam2 jFrame = new JMenuExam2();
			jFrame.setVisible(true);
		});
	}

}
