import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Creates the prompts that ask for the user's input.
 * @author Andrew, Braxton, Arron
 *
 */
public class PromptManager{
	
	String message;
	MainView mainView;
	JFrame parent;
    boolean returnType;
	
	
	/**
	 * The constructor for the PromptManager.
	 * @param m
	 */
	public PromptManager(MainView m){
		message = "";
		mainView = m;
	}
		
	/**
	 * Displays a message to the user
	 * @param message
	 */
	public void displayMessage(String m){
		parent = new JFrame();
		
		JOptionPane pane = new JOptionPane();
        pane.setMessage(m);
        
        JButton ok = new JButton("Ok");
        Object[] options = {ok};
        pane.setOptions(options);
        
        ok.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
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
	public String[] displayLines2(String m1, String m2){
		String[] textFields = new String[2];
		String[] failed = {"",""};
		JPanel panel = new JPanel(new GridLayout(2,2));
		Label l1 = new Label(m1);
		Label l2 = new Label(m2);
		Object[] options = {"Ok"};
		JTextField tF1 = new JTextField();
		JTextField tF2 = new JTextField();
		panel.add(l1);
		panel.add(tF1);
		panel.add(l2);
		panel.add(tF2);
		
		int result = JOptionPane.showOptionDialog(null, panel, message, JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, null);
		if(result == JOptionPane.OK_OPTION){
			textFields[0] = tF1.getText();
			textFields[1] = tF2.getText();
			return textFields;
		}
		else return failed;
	}
	
	/**
	 * Displays a dialog for one input custom prompt
	 * Shows message, text box
	 * @param message
	 */
	public String displayLines1(String m){
		JPanel panel = new JPanel(new GridLayout(2,1));
		Label label = new Label(m);
		Object[] options = {"OK", "Cancel"};
		JTextField textField = new JTextField();
		panel.add(label);
		panel.add(textField);
		
		int result = JOptionPane.showOptionDialog(
						null, 
						panel, 
						"Input", 
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, 
						null, 
						options, 
						null
					);
		
		if(result == JOptionPane.OK_OPTION){
			return textField.getText();
		}
		else return "";
	}
	
	/**
	 * Displays dialog with custom prompt
	 * @param message
	 */
	public boolean displayBool(String message){
		return JOptionPane.showConfirmDialog(
					new JFrame(),
					message,
					"Confirm",
					JOptionPane.YES_NO_OPTION
				) == 0;
	}
	
	/**
	 * Displays dialog with custom prompt
	 * @param message
	 */
	public int displayChoice(String message, String option1, String option2){
		Object[] options = {option1, option2};
		
		//create dialog box.  Store user responce
		return JOptionPane.showOptionDialog(
					new JFrame(),
			    	message,
			    	"Confirm",
			    	JOptionPane.YES_NO_OPTION,
			    	JOptionPane.QUESTION_MESSAGE,
			    	null,
			    	options,
			    	options[0]
				);
	}
}
