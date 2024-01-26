package swingExam.sec04;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CardLayoutExam extends JFrame{

	private JPanel redCard, greenCard, blueCard;
	
	// 메인 윈도우 설정
	public CardLayoutExam() {
		this.setTitle("CardLayoutExam");
		this.setSize(250,400);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// CardLayout으로 변경하고 3개의 카드 추가
		this.getContentPane().setLayout(new CardLayout());
		this.getContentPane().add("RedCard", getRedCard());
		this.getContentPane().add("BlueCard", getBlueCard());
		this.getContentPane().add("GreenCard", getGreenCard());
	}
	
	// RedCard Jpanel 생성
	public JPanel getRedCard() {
		if(redCard == null) {
			redCard = new JPanel();
			redCard.setBackground(Color.RED);
		}
		return redCard;
	}
	// GreenCard Jpanel 생성
	public JPanel getGreenCard() {
		if(greenCard == null) {
			greenCard = new JPanel();
			greenCard.setBackground(Color.GREEN);
		}
		return greenCard;
	}
	// BlueCard Jpanel 생성
	public JPanel getBlueCard() {
		if(blueCard == null) {
			blueCard = new JPanel();
			blueCard.setBackground(Color.BLUE);
		}
		return blueCard;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			final CardLayoutExam jFrame = new CardLayoutExam();
			jFrame.setVisible(true);
			// 반복 스레드 생성
			new Thread(()->{
				for(int i=0; i<10; i++) {
					try {
						Thread.sleep(1000);
					}catch(InterruptedException e) {
					}
					//이벤트 큐에 Runnable 객체 넣기
					SwingUtilities.invokeLater(()->{
						//CardLayout을 얻어 다음 카드 보여주기
						CardLayout cardLayout = (CardLayout) jFrame.getContentPane().getLayout();
						cardLayout.next(jFrame.getContentPane());
					});
				}
			}).start();	// 반복 스레드 시작
		});
	}
}
