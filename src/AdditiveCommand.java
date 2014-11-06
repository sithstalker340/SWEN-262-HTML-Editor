
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
		
		if(b.length() == 0 || end >= b.length() ){
			//replace file buffer with newer one
			file.setBuffer(text);
			isUndoable = true;
			buffer = b;
		}else{
			String newBuffer = b.substring(0,start) + text + b.substring(end);
			
			if(newBuffer != b){ 
				file.setBuffer(newBuffer); //update buffer
				this.isUndoable = true; //buffers are different, save the change
				this.buffer = b;
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
