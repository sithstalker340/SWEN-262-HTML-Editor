import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

//Methods to get and relay updates to the other view files
public class ViewListener implements ActionListener
{
	//Mediator mediator; // ViewListener shouldn't have a mediator object, it should be in InputHandler
	InputHandler input;
	
	public ViewListener(InputHandler i){
		input = i;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		//ButtonView
		if(arg0.getSource().getClass().isAssignableFrom((new JButton()).getClass())){
			String txt = ((JButton) arg0.getSource()).getText();
			System.out.println(txt);
			input.buttonViewInput(txt);
		}
		
		//MenuView
		if(arg0.getSource().getClass().isAssignableFrom((new JMenuItem()).getClass())){
			String txt = ((JMenuItem) arg0.getSource()).getText();
			input.menuViewInput(txt);
		}
	}
}
