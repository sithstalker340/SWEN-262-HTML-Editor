
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
		buffer = file.getBuffer();
		file.setBuffer(buffer.substring(0,startPos) + "<"+ text + ">" + buffer.substring(startPos,endPos) + "</" + text + ">"+ buffer.substring(endPos));
	}
	
	/**
	 * Undoes the addition of text from a file
	 */
	public void Undo(File file){
		file.setBuffer(buffer);
	}
}
