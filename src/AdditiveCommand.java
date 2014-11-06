
public class AdditiveCommand extends Command{
	
	private String text;
	private int startPos;
	private int endPos;
	private String buffer;
	
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
		
		if(buffer.length() == 0 || endPos >= buffer.length() ){
			//replace file buffer with newer one
			file.setBuffer(text);
			isUndoable = true;
			this.buffer = buffer;
		}else{
			String newBuffer = buffer.substring(0,startPos) + text + buffer.substring(endPos);
			
			if(newBuffer != buffer){ 
				file.setBuffer(newBuffer); //update buffer
				this.isUndoable = true; //buffers are different, save the change
				this.buffer = buffer;
			}else{ 
				return; //buffers are the same don't bother
			}
		}
	}
	
	/**
	 * Undoes the addition of text from a file
	 */
	public void Undo(File file){
		file.setBuffer(buffer);
	}
}
