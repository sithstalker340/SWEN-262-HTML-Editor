/**
 * Command that is sent when an image is inserted.
 * @author Adam
 *
 */
public class InsertImageCommand extends Command {
	
	/**
	 * Constructor for the image inserting command
	 * @param src
	 * @param startPosition
	 * @param endPosition
	 */
	public InsertImageCommand(String src, int startPosition, int endPosition){
		text = src;
		start = startPosition;
		end = endPosition;
		isUndoable = true;
	}
	
	/**
	 * Updates a file's text by replacing a string with the string plus a substring.
	 * @param file
	 */
	@Override
	public void Apply(File file) {
		buffer = file.getBuffer();
		String newBuffer = buffer.substring(0,start) + "<img src=" + "\"" + text + "\"" + ">" + buffer.substring(start,end) + "</img>"+ buffer.substring(end); 
		file.setBuffer(newBuffer);
	}
	
	/**
	 * Undoes the addition of text.
	 * @param file
	 */
	@Override
	public void Undo(File file) {
		file.setBuffer(buffer);
	}
}
