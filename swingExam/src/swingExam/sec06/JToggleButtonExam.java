package swingExam.sec06;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class JToggleButtonExam extends JFrame {
	private JPanel pFirst;
	private JPanel pSecond;
	private JToggleButton tbOnOff;
	private JToggleButton tbStart;
	private JToggleButton tbStop;

	// 메인 윈도우 설정
	public JToggleButtonExam() {
		this.setTitle("JToggleButtonExam");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(2, 1));
		this.getContentPane().add(getPFirst());
		this.getContentPane().add(getPSecond());
		this.pack();
	}

	public JPanel getPFirst() {
		if (pFirst == null) {
			pFirst = new JPanel();
			pFirst.add(getTbOnOff());
		}
		return pFirst;
	}

	public JPanel getPSecond() {
		if (pSecond == null) {
			pSecond = new JPanel();
			pSecond.setBorder(new TitledBorder("원하는 기능은?"));
			pSecond.add(getTbStart());
			pSecond.add(getTbStop());

			// 배타적 선택을 위한 ButtonGroup 생성 및 토글 버튼 추가
			ButtonGroup buttonGroup = new ButtonGroup();
			buttonGroup.add(getTbStart());
			buttonGroup.add(getTbStop());
		}
		return pSecond;
	}

	// On/Off 토글 버튼 생성
	public JToggleButton getTbOnOff() {
		if(tbOnOff==null) {
			tbOnOff = new JToggleButton();
			tbOnOff.setText("On");
			tbOnOff.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange()==ItemEvent.SELECTED) {
						getTbOnOff().setText("Off");
					}else {
						getTbOnOff().setText("On");
					}
				}
			});
		}
		return tbOnOff;
	}
	
	// Start 토글 버튼 생성
	public JToggleButton getTbStart() {
		if(tbStart==null) {
			tbStart = new JToggleButton();
			tbStart.setText("Start");
			tbStart.setIcon(new ImageIcon(getClass().getResource("../image1.jpg")));
			tbStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(JToggleButtonExam.this, "Start");
				}
			});
		}
		return tbStart;
	}
	
	// Stop 토글 버튼 생성
	public JToggleButton getTbStop() {
		if(tbStop==null) {
			tbStop = new JToggleButton();
			tbStop.setText("Stop");
			tbStop.setIcon(new ImageIcon(getClass().getResource("../image2.jpg")));
			tbStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(JToggleButtonExam.this, "Stop");
				}
			});
		}
		return tbStop;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			JToggleButtonExam jFrame = new JToggleButtonExam();
			jFrame.setVisible(true);
		});
	}

}
