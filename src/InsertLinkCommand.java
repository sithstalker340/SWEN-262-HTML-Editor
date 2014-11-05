
public class InsertLinkCommand extends Command {
	
	private String url;
	private int startPos;
	private int endPos;
	private String buffer;
	
	public InsertLinkCommand(String url, int startPosition, int endPosition){
		this.url = url;
		startPos = startPosition;
		endPos = endPosition;
		this.isUndoable = true;
	}
	
	/**
	 * Updates a file's text by replacing
	 * it with the text + a desired substring
	 */
	public void Apply(File file){
		buffer = file.getBuffer();
		file.setBuffer(buffer.substring(0,startPos) + "<a href=" + "\"" + url + "\"" + ">" + buffer.substring(startPos,endPos) + "</a>"+ buffer.substring(endPos));
	}
	
	/**
	 * Undoes the addition of text from a file
	 */
	public void Undo(File file){
		file.setBuffer(buffer);
	}
}
