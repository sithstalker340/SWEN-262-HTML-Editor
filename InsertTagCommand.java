
public class InsertTagCommand extends Command{
	
	private String text;
	private int startPos;
	private int endPos;
	private String buffer;
	
	public InsertTagCommand(String textString, int startPosition, int endPosition){
		text = textString;
		startPos = startPosition;
		endPos = endPosition;
	}
	
	/**
	 * Updates a file's text by replacing
	 * it with the text + a desired substring
	 */
	public void Apply(File file){
	if(text == "ul"){
		
	}
	else{
		insertTag(file);
	}
		
	}
	
	/**
	 * Undoes the addition of text from a file
	 */
	public void Undo(File file){
		file.setBuffer(buffer);
	}
	
	public void insertTag(File f){
		buffer = f.getBuffer();
		f.setBuffer(buffer.substring(0,startPos) + "<"+ text + ">" + buffer.substring(startPos,endPos) + "</" + text + ">"+ buffer.substring(endPos));
	}
}