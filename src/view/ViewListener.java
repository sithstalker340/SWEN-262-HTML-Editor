package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import patterns.InputHandler;

/**
 * Methods to get and relay updates to the other view files
 * @author Dylan
 *
 */
public class ViewListener implements ActionListener
{
	InputHandler input;
	
	/**
	 * The constructor of the ViewListener class.
	 * @param i
	 */
	public ViewListener(InputHandler i){
		input = i;
	}

	/**
	 * Listeners for the Buttons and Menu items.
	 */
	public void actionPerformed(ActionEvent arg0) 
	{
		//ButtonView
		if(arg0.getSource().getClass().isAssignableFrom((new JButton()).getClass())){
			String txt = ((JButton) arg0.getSource()).getText();
			input.buttonViewInput(txt);
		}
		
		//MenuView
		if(arg0.getSource().getClass().isAssignableFrom((new JMenuItem()).getClass())){
			String txt = ((JMenuItem) arg0.getSource()).getText();
			input.menuViewInput(txt);
		}
	}
}
