package patterns;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.ImagePreviewer;

public class InputHandler {

	private Mediator mediator; 
	final JFileChooser fc;
	
	public InputHandler(Mediator m){
		mediator = m;
		fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("HTML", "html"));
	}
	
	/**
	 * Handles the events fired from a button being pressed
	 * @param txt
	 */
	public void buttonViewInput(String tag){
		//TODO confirm update condition in this if statement is correct
		if(!tag.equals("Subtractive") && !tag.equals("update") && !mediator.getIsFunctional()){
			return;
		}
		
		String type = "tag";
		
		switch(tag){
			case "a": type = "link";break;
			case "ol": type = "list";break;		
			case "ul": type = "list";break;
			case "dl": type = "list";break;
			case "table": type = "table";break;
			case "img": type = "img";break;
			case "update": type =tag; break;
			case "Subtractive": type=tag; break;
		}
		
		if(mediator.getMainViewText() != null){
			mediator.pushCommand(tag, type);
		}
	}
	
	/**
	 * Handles the events fired from a menu selection
	 * @param txt
	 */
	public void menuViewInput(String txt){
		switch(txt){
			case "New":
				mediator.createNewFile("new");
				break;
				
			case "Save":				
				if(mediator.canSave()){
					if(mediator.save() == true){
						mediator.setIsSaved(true);
					}
					else menuViewInput("Save As...");
				}
				break;
				
			case "Save As...":				
				if(mediator.canSave()){
					int returnVal = fc.showSaveDialog(fc);
					
					if(returnVal == JFileChooser.APPROVE_OPTION){
						java.io.File file = fc.getSelectedFile();
						String location = file.getPath().toString();
						
						mediator.saveAs(location);
						mediator.setIsSaved(true);
					}
				}
				break;
				
			case "Open File...":
				int returnVal = fc.showOpenDialog(fc);	
				
				if(returnVal == JFileChooser.APPROVE_OPTION){
					java.io.File file = fc.getSelectedFile();
					mediator.openFile(file.getName(), file.getPath());
				}
				
				else System.out.println("Error opening file");
				break;
			
			case "Exit":
				mediator.quit();
				break;
			
			case "Undo":
				mediator.popCommand();
				break;
			
			case "Redo":
				mediator.redoCommand();
				break;
			
			case "Word Wrap":
				if(mediator.getIsFunctional()){
					mediator.toggleWordWrap();
				}
				break;
			
			case "Linked view":	
				if(mediator.getIsFunctional()){
					mediator.createNewLinkedView();
				}
				break;
			
			case "Preview image":
				if(mediator.getIsFunctional()){
					new ImagePreviewer(mediator.getMainViewText());
				}
				break;
				
			case "Tag layout":
				if(mediator.getIsFunctional()){
					mediator.pushCommand("", "tagLayout");
				}
				break;
		}
	}
	
	public void changeCurrentFile(int id){
		mediator.changeCurrentFile(id);
	}
	
	public void updateFileBuffer(){
		mediator.updateFileBuffer();
	}
	
	public void setIsSaved(boolean b){
		mediator.setIsSaved(b);
	}
	
	public void quit(){
		mediator.quit();
	} 
	
	public boolean closeTab(int id){
		return mediator.closeTab(id);
	}
	
	public void updateLinkedView(){
		mediator.updateLinkedView();
	}
}
