
public class SubtractiveCommand extends Command{
	
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
