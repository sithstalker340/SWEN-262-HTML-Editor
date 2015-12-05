package commands;
import editor.File;

/**
 * Command for inserting a List
 * @author Adam
 */
public class InsertListCommand extends Command {
	
	/**
	 * Constructor for list inserting command
	 * @param file
	 */
	public InsertListCommand(String tag, int start, int numRows){
		text = "";
		text += '<' + tag + '>';
		
		for(int i = 0; i < numRows; i++){
			text += '\n';
			
			if(tag.equals("dl")){
				text += "<dt> </dt>" + '\n' + "<dd> </dd>";
			}else{
				text += "<li> </li>";				
			}
		}
		
		text += '\n' + "</" + tag + ">";	
		
		this.start = start;
		isUndoable = true;
	}
	
	/**
	 * Updates a file's text by replacing
	 * it with the text + a desired substring
	 * @param file
	 */
	public void Apply(File file) {
		buffer = file.getBuffer();
		
	    String newBuffer = buffer.substring(0,start) + text + buffer.substring(start);
	    
		file.setBuffer( newBuffer );
	}
	
	/**
	 * Undoes the addition of text from a file
	 * @param file
	 */
	public void Undo(File file) {
		file.setBuffer(buffer);		
	}

}
