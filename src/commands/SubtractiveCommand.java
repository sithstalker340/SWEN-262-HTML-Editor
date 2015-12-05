package commands;
import editor.File;

/**
 * Command that deletes text.
 * @author Braxton
 *
 */
public class SubtractiveCommand extends Command{
	
	/**
	 * The constructor for the SubtractiveCommand class.
	 * @param textString
	 * @param startPosition
	 * @param endPosition
	 */
	public SubtractiveCommand(String textString, int startPosition, int endPosition){
		text = textString;
		start = startPosition;
		end = endPosition;
		isUndoable = true;
	}
	
	/**
	 * Updates a file's text by replacing
	 * it with the text - a desired substring
	 */
	public void Apply(File file){
		buffer = file.getBuffer();
		file.setBuffer(text);
	}
	
	/**
	 * Undoes the removal of text from a file
	 */
	public void Undo(File file){
		file.setBuffer(buffer);
	}
}
