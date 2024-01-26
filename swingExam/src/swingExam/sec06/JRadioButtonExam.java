package swingExam.sec06;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class JRadioButtonExam extends JFrame {

	private JPanel radioPanel;
	private JRadioButton rbBass1;
	private JRadioButton rbBass2;
	private JLabel lblPicture;

	// 메인 윈도우 설정
	public JRadioButtonExam() {
		setTitle("JRadioButtonExam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(getRadioPanel(), BorderLayout.WEST);
		this.getContentPane().add(getLblPicture(), BorderLayout.CENTER);
		pack();
	}

	// JRadioButton이 배치된 JPanel 생성
	public JPanel getRadioPanel() {
		if (radioPanel == null) {
			radioPanel = new JPanel();
			radioPanel.setLayout(new GridLayout(2, 1));
			radioPanel.add(getRbBass1());
			radioPanel.add(getRbBass2());

			// 배타적 선택을 위해 ButtonGroup에 두 개의 JRadioButton 추가
			ButtonGroup group = new ButtonGroup();
			group.add(getRbBass1());
			group.add(getRbBass2());
		}
		return radioPanel;
	}

	// JRadioButton 생성
	public JRadioButton getRbBass1() {
		if (rbBass1 == null) {
			rbBass1 = new JRadioButton();
			rbBass1.setText("Bass1");
			rbBass1.setSelected(true);
			rbBass1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLblPicture().setIcon(new ImageIcon(getClass().getResource("../image2.jpg")));
				}
			});
		}
		return rbBass1;
	}
	
	// JRadioButton 생성
	public JRadioButton getRbBass2() {
		if(rbBass2==null) {
			rbBass2 = new JRadioButton();
			rbBass2.setText("Bass2");
			rbBass2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLblPicture().setIcon(new ImageIcon(getClass().getResource("../image3.jpg")));
				}
			});
		}
		return rbBass2;
	}
	
	// 이미지를 보여줄 JLabel 생성
	public JLabel getLblPicture() {
		if(lblPicture==null) {
			lblPicture = new JLabel();
			lblPicture.setIcon(new ImageIcon(getClass().getResource("../image2.jpg")));
		}
		return lblPicture;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			JRadioButtonExam jFrame = new JRadioButtonExam();
			jFrame.setVisible(true);
		});
	}

}
