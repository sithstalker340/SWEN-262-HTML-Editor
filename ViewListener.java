import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

//Methods to get and relay updates to the other view files
public class ViewListener implements ActionListener
{
	//Mediator mediator; // ViewListener shouldn't have a mediator object, it should be in InputHandler
	InputHandler input;
	final JFileChooser fc;
	
	public ViewListener(InputHandler i){
		fc = new JFileChooser();
		input = i;
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
					System.out.println("Save Clicked");
					
					if(input.getMediator().fileHandler.canSave()){
						input.getMediator().fileHandler.save();
					}
					break;
					
				case "Open File...":
					//System.out.println("Open File...");
					int returnVal = fc.showOpenDialog(fc);	
					
					if(returnVal == JFileChooser.APPROVE_OPTION){
						java.io.File file = fc.getSelectedFile();
						String name = file.getPath().toString();
						//System.out.println("path name: " + name);
						File openedFile = input.getMediator().fileHandler.load(name);
						System.out.println(openedFile.getBuffer());
						//to be impletented: updating the window with the file's text
						
						input.mainView.textView.resetLastCharIn();
						input.getMediator().setTextAreaString(openedFile.getBuffer());
					}
					
					else System.out.println("Error opening file");
				break;
				
				case "Exit":
					System.exit(0);
				break;
			}
		}
		
		if(arg0.getSource().getClass().isAssignableFrom(JTextArea.class)){
			System.out.println("TextArea updated");
		}
	}

	public InputHandler getInput(){
		return input;
	}
	
}
