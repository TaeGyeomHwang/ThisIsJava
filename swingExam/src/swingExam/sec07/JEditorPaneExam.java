package swingExam.sec07;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;

public class JEditorPaneExam extends JFrame {

	private JEditorPane jEditorPane;

	// 메인 윈도우 설정
	public JEditorPaneExam() {
		this.setTitle("JEditorPaneExam");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(getJEditorPane()), BorderLayout.CENTER);
		this.setSize(400, 300);
	}
	
	// JEditorPane 생성
	public JEditorPane getJEditorPane() {
		if(jEditorPane==null) {
			jEditorPane = new JEditorPane();
			try {
				jEditorPane.setPage(getClass().getResource("../index.html"));
			}catch(Exception e) {
			}
			jEditorPane.setEditable(false);
			jEditorPane.addHyperlinkListener(e->{
				if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED) {
					try {
						jEditorPane.setPage(e.getURL());
					}catch(IOException e2) {
					}
				}
			});
		}
		return jEditorPane;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			JEditorPaneExam jFrame = new JEditorPaneExam();
			jFrame.setVisible(true);
		});
	}

}
