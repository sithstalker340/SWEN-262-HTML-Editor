import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

//Methods to get and relay updates to the other view files
public class ViewListener implements ActionListener
{
	Mediator mediator;
	final JFileChooser fc;
	
	public ViewListener(){
		fc = new JFileChooser();
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
				if(mediator.fileHandler.canSave()){
					mediator.fileHandler.save();
				}
				
			}
			else if(txt == "Open File...")
			{
				System.out.println("Open File...");
				int returnVal = fc.showOpenDialog(fc);	
				if(returnVal == JFileChooser.APPROVE_OPTION){
					java.io.File file = fc.getSelectedFile();
					String name = file.getPath().toString();
					System.out.println("path name: " + name);
					mediator.fileHandler.load(name);
				}
				
				else{
					System.out.println("Error opening file");
				}
			}
			
			else if(txt == "Exit"){
				System.exit(0);
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
