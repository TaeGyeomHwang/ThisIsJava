package swingExam.sec06;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JCheckBoxExam extends JFrame {
	private JPanel pWest;
	private JCheckBox cbBass1;
	private JCheckBox cbBass2;
	private JLabel lblPicture;

	// 메인 윈도우 설정
	public JCheckBoxExam() {
		this.setTitle("JCheckBoxExam");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(getPWest(), BorderLayout.WEST);
		this.getContentPane().add(getLblPicture(), BorderLayout.CENTER);
		this.pack();
	}

	// 서쪽에 부착할 JPanel 생성
	public JPanel getPWest() {
		if (pWest == null) {
			pWest = new JPanel(new GridLayout(2, 1));
			// JCheckBox 추가
			pWest.add(getCbBass1());
			pWest.add(getCbBass2());
		}
		return pWest;
	}

	// JChekBox 생성
	public JCheckBox getCbBass1() {
		if (cbBass1 == null) {
			cbBass1 = new JCheckBox();
			cbBass1.setText("Bass1");
			cbBass1.addActionListener(actionListener);
		}
		return cbBass1;
	}

	// JChekBox 생성
	public JCheckBox getCbBass2() {
		if (cbBass2 == null) {
			cbBass2 = new JCheckBox();
			cbBass2.setText("Bass2");
			cbBass2.addActionListener(actionListener);
		}
		return cbBass2;
	}

	// 이미지를 보여줄 JLabel 생성
	public JLabel getLblPicture() {
		if (lblPicture == null) {
			lblPicture = new JLabel();
			lblPicture.setIcon(new ImageIcon(getClass().getResource("../image.jpg")));
		}
		return lblPicture;
	}

	// JCheckBox 이벤트 처리 리스너를 위한 필드 선언
	private ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (cbBass1.isSelected() && cbBass2.isSelected()) {
				lblPicture.setIcon(new ImageIcon(getClass().getResource("../image1.jpg")));
			}else if(cbBass1.isSelected()) {
				lblPicture.setIcon(new ImageIcon(getClass().getResource("../image2.jpg")));
			}else if(cbBass2.isSelected()) {
				lblPicture.setIcon(new ImageIcon(getClass().getResource("../image3.jpg")));
			}else {
				lblPicture.setIcon(new ImageIcon(getClass().getResource("../image.jpg")));
			}
		}
	};

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			JCheckBoxExam jFrame = new JCheckBoxExam();
			jFrame.setVisible(true);
		});
	}

}
