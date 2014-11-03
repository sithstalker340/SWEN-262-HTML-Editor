import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PromptManager{
	
	String message;
	MainView mainView;
	JFrame parent;
	
	//PromptHandler constructor
	public PromptManager(MainView m){
		message = "";
		mainView = m;
	}
	
	public void createNewPrompt(int options, String m){
		message = m;
		
		switch(options){
		case 0: // no user feedback
				displayMessage(m);
				System.out.println("0 selected");
			break;
			
		case 1: // user selects yes or no
				displayBool(m);
			break;
			
		case 2: // user enters 1 string
				displayLines1(m);
			break;
		case 3: // user enters 2 strings
				
			break;
		}
	}
	
	/**
	 * Displays a message to the user
	 * @param message
	 */
	private void displayMessage(String m){
		parent = new JFrame();
		
		JOptionPane pane = new JOptionPane();
        pane.setMessage(m);
        
        JButton ok = new JButton("Ok");
        Object[] options = {ok};
        pane.setOptions(options);
        
        ok.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		returnBoolPrompt("true");
        		parent.dispose();
        	}
        });
        
        parent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        parent.add(pane);
        parent.pack();
        parent.setLocationRelativeTo(null);
		parent.setVisible(true);	
	}
	
	/**
	 * Displays a dialog for two input custom prompt
	 * Shows message1, text box, message2, text box
	 * @param message1, message2
	 */
	private String[] displayLines2(String message1, String message2){
		return null;
	}
	
	/**
	 * Displays a dialog for one input custom prompt
	 * Shows message, text box
	 * @param message
	 */
	private String displayLines1(String m){
		JPanel panel = new JPanel(new GridLayout(2,1));
		Label label = new Label(m);
		Object[] options = {"Yes", "No"};
		JTextField textField = new JTextField();
		panel.add(label);
		panel.add(textField);
		
		int result = JOptionPane.showOptionDialog(null, panel, "Testing", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, null);
		if(result == JOptionPane.OK_OPTION){
			System.out.println(textField.getText());
			return textField.getText();
		}
		else return "";
	}
	
	/**
	 * Displays dialog with custom prompt
	 * @param message
	 */
	private void displayBool(String m){
		parent = new JFrame();
		
		JOptionPane pane = new JOptionPane();
        pane.setMessage(m);
        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");
        Object[] options = {yes, no};
        pane.setOptions(options);
        
        yes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		returnBoolPrompt("true");
        		parent.dispose();
        	}
        });
        
        no.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		returnBoolPrompt("false");
        		parent.dispose();
        	}
        });
        
        parent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        parent.add(pane);
        parent.pack();
        parent.setLocationRelativeTo(null);
		parent.setVisible(true);	
		parent.setFocusable(true);
	}
	
	public boolean returnBoolPrompt(String b){
		System.out.println(b);
		
		if(b == "true"){ 
			return true;
		}
		
		else return false;
	}
}

