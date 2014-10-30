import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

//Methods to get and relay updates to the other view files
public class ViewListener implements ActionListener
{
	Mediator mediator; // ViewListener shouldn't have a mediator object, it should be in InputHandler
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
			
			switch(txt){
			case "<b>":
				System.out.println("BOLD TAG");
				break;
				
			case "<i>":
				System.out.println("ITALICS TAG");
				break;
				
			case "<a>":
				System.out.println("LINK TAG");
				break;
				
			case "<Header>":
				System.out.println("HEADER TAG");
				break;
			}
		}
		
		//MenuView
		if(arg0.getSource().getClass().isAssignableFrom((new JMenuItem()).getClass()))
		{
			String txt = ((JMenuItem) arg0.getSource()).getText();
			
			switch(txt){
				case "Save":
					System.out.println("Save");
					if(mediator.fileHandler.canSave()){
						mediator.fileHandler.save();
					}
					break;
					
				case "Open File...":
					System.out.println("Open File...");
					int returnVal = fc.showOpenDialog(fc);	
					
					if(returnVal == JFileChooser.APPROVE_OPTION){
						java.io.File file = fc.getSelectedFile();
						String name = file.getPath().toString();
						System.out.println("path name: " + name);
						mediator.fileHandler.load(name);
					}
					
					else System.out.println("Error opening file");
				break;
				
				case "Exit":
					System.exit(0);
				break;
			}
		}
	}
	
	/**
	 * ViewListener should not have a mediator object
	 * This is temporary until it is moved into the InputHandler class
	 * @param med
	 */
	public void setMediator(Mediator med)
	{
		mediator = med;
	}

	/**
	 * @param args
	 */
	
}
