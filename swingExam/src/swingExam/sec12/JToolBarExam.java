package swingExam.sec12;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.SoftBevelBorder;

public class JToolBarExam extends JFrame {

	private JMenuBar jMenuBar;
	private JToolBar jToolBar;
	private JButton btnNew, btnSave, btnCopy, btnPaste;

	public JToolBarExam() {
		this.setTitle("JToolBarExam");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(getJMenuBar());
		this.getContentPane().add(getJToolBar(), BorderLayout.NORTH);
		this.setSize(300, 200);
	}
	
	public JMenuBar getJMenuBar() {
		if(jMenuBar==null) {
			jMenuBar = new JMenuBar();
			jMenuBar.add(new JMenu("파일"));
			jMenuBar.add(new JMenu("도움말"));
		}
		return jMenuBar;
	}
	
	public JToolBar getJToolBar() {
		if(jToolBar==null) {
			jToolBar = new JToolBar();
			jToolBar.add(getBtnNew());
			jToolBar.add(getBtnSave());
			jToolBar.addSeparator();
			jToolBar.add(getBtnCopy());
			jToolBar.add(getBtnPaste());
		}
		return jToolBar;
	}
	
	public JButton getBtnNew() {
		if(btnNew==null) {
			btnNew = new JButton();
			btnNew.setIcon(new ImageIcon(getClass().getResource("../image1.jpg")));
			btnNew.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
			btnNew.setToolTipText("새로만들기");
			btnNew.addActionListener(actionListener);
		}
		return btnNew;
	}
	
	public JButton getBtnSave() {
		if(btnSave==null) {
			btnSave = new JButton();
			btnSave.setIcon(new ImageIcon(getClass().getResource("../image2.jpg")));
			btnSave.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
			btnSave.setToolTipText("저장");
			btnSave.addActionListener(actionListener);
		}
		return btnSave;
	}
	public JButton getBtnCopy() {
		if(btnCopy==null) {
			btnCopy = new JButton();
			btnCopy.setIcon(new ImageIcon(getClass().getResource("../image3.jpg")));
			btnCopy.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
			btnCopy.setToolTipText("복사");
			btnCopy.addActionListener(actionListener);
		}
		return btnCopy;
	}
	public JButton getBtnPaste() {
		if(btnPaste==null) {
			btnPaste = new JButton();
			btnPaste.setIcon(new ImageIcon(getClass().getResource("../image.jpg")));
			btnPaste.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
			btnPaste.setToolTipText("붙여넣기");
			btnPaste.addActionListener(actionListener);
		}
		return btnPaste;
	}
	
	public ActionListener actionListener = e->{
		if(e.getSource()==btnNew) {
			JOptionPane.showMessageDialog(JToolBarExam.this, "[새로만들기]를 클릭");
		}else if(e.getSource()==btnSave) {
			JOptionPane.showMessageDialog(JToolBarExam.this, "[저장]을 클릭");
		}else if(e.getSource()==btnCopy) {
			JOptionPane.showMessageDialog(JToolBarExam.this, "[복사]를 클릭");
		}else if(e.getSource()==btnPaste) {
			JOptionPane.showMessageDialog(JToolBarExam.this, "[붙여넣기]를 클릭");
		}
	};

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			JToolBarExam jFrame = new JToolBarExam();
			jFrame.setVisible(true);
		});
	}

}
