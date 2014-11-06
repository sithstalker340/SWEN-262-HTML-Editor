
public class InsertLinkCommand extends Command {
	
	public InsertLinkCommand(String url, int startPosition, int endPosition){
		text = url;
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
		String newBuffer = buffer.substring(0,start) + "<a href=" + "\"" + text + "\"" + ">" + buffer.substring(start,end) + "</a>"+ buffer.substring(end);
		file.setBuffer(newBuffer);
	}
	
	/**
	 * Undoes the addition of text from a file
	 */
	public void Undo(File file){
		file.setBuffer(buffer);
	}
}
