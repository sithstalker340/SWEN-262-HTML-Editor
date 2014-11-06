import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class LinkedView extends JFrame {
	JTextArea linkedViewList;
	JPanel contentPane;
	JButton button;
	LinkedViewStrategy strategy;
	String fileBuffer;
	MainView mainView;
	
	public LinkedView(MainView m, LinkedViewStrategy strategy,String text){
		this.strategy = strategy;
		fileBuffer = text;
		mainView = m;
		
		this.setMinimumSize(new Dimension(300,450));
		this.setTitle(strategy.getName());
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        
        button = new JButton("Refresh");
        
        button.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e){
        		mainView.getInputHandler().updateLinkedView();
        	}
        });
                
        linkedViewList = new JTextArea();
        linkedViewList.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() - button.getHeight()));
        linkedViewList.setEditable(false);
        
        contentPane.add(linkedViewList, BorderLayout.NORTH);
        contentPane.add(button, BorderLayout.SOUTH);
        
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
        this.setLocationRelativeTo(mainView);
        this.setVisible(true);
	}
	
	public void updateLinkList(String newBuffer){
		fileBuffer = newBuffer;
		linkedViewList.setText("");
		
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
	}
}
