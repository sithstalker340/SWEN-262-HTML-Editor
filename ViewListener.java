import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

//Methods to get and relay updates to the other view files
public class ViewListener implements ActionListener
{
	Mediator mediator;
	final JFileChooser fc = new JFileChooser();
	
	public ViewListener(){
		
	}

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
			String txt = ((JMenuItem) arg0.getSource()).getText();
			//System.out.println(this.getClass().getDeclaringClass().toString());
			if(txt == "Save")
			{
				System.out.println("Save");
				mediator.fileHandler.save();
				
			}
			else if(txt == "Open File...")
			{
				System.out.println("Open File...");
				int returnVal = fc.showOpenDialog(fc);
				java.io.File file = fc.getSelectedFile();
			
				System.out.println(file.getPath());
				String name = file.getPath().toString();
				mediator.fileHandler.load(name);
			}
		}
		
	}
	
	public void setMediator(Mediator med)
	{
		mediator = med;
	}

	/**
	 * @param args
	 */
	
}
