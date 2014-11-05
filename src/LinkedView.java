import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

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
        
        List<String> bufferList = strategy.parse(fileBuffer);
        List<Integer> intList = strategy.numOccur();
        
        for(int i = 0; i < bufferList.size(); i++){
        	if(intList != null){ //for alphabetical
        		linkedViewList.append("url: " + bufferList.get(i) + " count: " + intList.get(i) + '\n');
        	}
        	
        	//for appearance
        	else{ 
        		linkedViewList.append("url: " + bufferList.get(i) + '\n'); 
        	}
        }

        this.setContentPane(contentPane);      
        this.pack();
        this.setLocationRelativeTo(null);
	}
}
