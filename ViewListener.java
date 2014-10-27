import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

//Methods to get and relay updates to the other view files
public class ViewListener implements ActionListener
{

	public ViewListener(){}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		//ButtonView
		if(arg0.getSource().getClass().isAssignableFrom((new JButton()).getClass()))
		{
			String txt = ((JButton) arg0.getSource()).getText();
			System.out.println(((JButton) arg0.getSource()).getText());
			if(txt == "<b>")
			{
				System.out.println("BOLD TAG");
			}
			else if(txt == "<i>")
			{
				System.out.println("ITALICS TAG");
			}
			else if(txt == "<a>")
			{
				System.out.println("LINK TAG");
			}
			else if(txt == "<Header>")
			{
				System.out.println("HEADER TAG");
			}
		}
		//MenuView
		if(arg0.getSource().getClass().isAssignableFrom((new JMenuItem()).getClass()))
		{
			System.out.println(((JMenuItem) arg0.getSource()).getText());
		}
		
	}

	/**
	 * @param args
	 */
	
}
