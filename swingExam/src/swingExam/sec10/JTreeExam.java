package swingExam.sec10;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

public class JTreeExam extends JFrame {
	private JTree jTree;

	public JTreeExam() {
		this.setTitle("JTreeExam");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(getJTree()), BorderLayout.CENTER);
		this.setSize(200, 150);
	}
	
	public JTree getJTree() {
		if(jTree==null) {
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("그룹리스트");
			
			DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("친구");
			node1.add(new DefaultMutableTreeNode("친구1"));
			node1.add(new DefaultMutableTreeNode("친구2"));
			root.add(node1);
			
			DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("회사동료");
			node2.add(new DefaultMutableTreeNode("동료1"));
			node2.add(new DefaultMutableTreeNode("동료2"));
			root.add(node2);
			
			jTree = new JTree(root);
		}
		return jTree;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			JTreeExam jFrame = new JTreeExam();
			jFrame.setVisible(true);
		});
	}

}
