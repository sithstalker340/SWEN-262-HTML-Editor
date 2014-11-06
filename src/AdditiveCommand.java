/**
 * Adds text to the given position.
 * @author Braxton
 *
 */
public class AdditiveCommand extends Command{

	public AdditiveCommand(String textString, int startPosition, int endPosition){
		text = textString;
		start = startPosition;
		end = endPosition;
		
		if(end == start){
			end = start + text.length();
		}
		
		this.isUndoable = false;
	}
	
	/**
	 * Updates a file's text by replacing
	 * it with the text + a desired substring
	 */
	public void Apply(File file){
		String b = file.getBuffer();
		
		if(text.equals(b)){
			return; //buffers are the same
		}else{
			isUndoable = true;
			buffer = b;
			file.setBuffer(text);
		}
	}
	
	/**
	 * Undoes the addition of text from a file
	 */
	public void Undo(File file){
		file.setBuffer(buffer);
	}
}
