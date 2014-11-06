
public class InsertTagCommand extends Command{
	
	public InsertTagCommand(String textString, int startPosition, int endPosition){
		text = textString;
		start = startPosition;
		end = endPosition;
		isUndoable = true;
	}
	
	/**
	 * Updates a file's text by replacing
	 * it with the text + a desired substring
	 */
	public void Apply(File file){
		buffer = file.getBuffer();
			
		int temp = start;
		if(start > end){
			start = end;
			end = temp;
		}
		
		String newBuffer = buffer.substring(0,start) + "<"+ text + ">" + buffer.substring(start,end) + "</" + text + ">"+ buffer.substring(end);
		file.setBuffer(newBuffer);
	}
	
	/**
	 * Undoes the addition of text from a file
	 */
	public void Undo(File file){
		file.setBuffer(buffer);
	}
}
