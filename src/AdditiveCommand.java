
public class AdditiveCommand extends Command{
	
	private String text;
	private int startPos;
	private int endPos;
	
	public AdditiveCommand(String textString, int startPosition, int endPosition){
		text = textString;
		startPos = startPosition;
		endPos = endPosition;
		
		if(endPos == startPos){
			endPos = startPos + text.length();
		}
		
		this.isUndoable = false;
	}
	
	/**
	 * Updates a file's text by replacing
	 * it with the text + a desired substring
	 */
	public void Apply(File file){
		String buffer = file.getBuffer();
		String newBuffer = "";
		
		if(buffer.length() == 0){
			file.setBuffer(text);
		}
		else{
			if(endPos >= buffer.length()){			
				//newBuffer = buffer.substring(0,startPos) + text + buffer.substring(endPos - 1);
				file.setBuffer(text);
			}else{
				newBuffer = buffer.substring(0,startPos) + text + buffer.substring(endPos);
				file.setBuffer(newBuffer);
			}
		}
		
		if(newBuffer != buffer){
			this.isUndoable = true;
		}
	}
	
	/**
	 * Undoes the addition of text from a file
	 */
	public void Undo(File file){
		String buffer = file.getBuffer();
		file.setBuffer(buffer.substring(0, startPos) + buffer.substring(endPos));
	}
}
