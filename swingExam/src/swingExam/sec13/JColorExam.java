package swingExam.sec13;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JColorExam extends JFrame {
	private JButton btnColor;

	public JColorExam() {
		this.setTitle("JColorChooserExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(1, 1));
		this.getContentPane().add(getBtnColor());
		this.setSize(150, 60);
	}

	public JButton getBtnColor() {
		if (btnColor == null) {
			btnColor = new JButton();
			btnColor.setText("JColorChooser");
			btnColor.addActionListener(e -> {
				Color color = JColorChooser.showDialog(JColorExam.this, "색상 선택", Color.blue);
				btnColor.setBackground(color);
			});
		}
		return btnColor;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JColorExam jFrame = new JColorExam();
			jFrame.setVisible(true);
		});
	}
}
