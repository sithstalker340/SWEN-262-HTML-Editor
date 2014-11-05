import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class LinkedView extends JFrame {
	JTextArea linkedViewList;
	JPanel contentPane;
	LinkedViewStrategy strategy;
	String fileBuffer;
	
	public LinkedView(LinkedViewStrategy strategy,String text){
		this.strategy = strategy;
		fileBuffer = text;
		this.setMinimumSize(new Dimension(300,450));
		this.setTitle("Linked View");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5, 5));
        linkedViewList = new JTextArea();
        linkedViewList.setEditable(false);
        contentPane.add(linkedViewList);
        for(String s: strategy.parse(fileBuffer))
        	linkedViewList.append(s + '\n');
        this.setContentPane(contentPane);      
        this.pack();
	}
}
