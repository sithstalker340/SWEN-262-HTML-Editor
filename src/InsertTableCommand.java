
public class InsertTableCommand extends Command {
	private int startPos;
	private String text;
	private String buffer;
	
	public InsertTableCommand(int startPosition, int _rows, int _cols){
		startPos = startPosition;
		
		//construct table
		text = "<table>";
		for(int r = 0; r < _rows; r++){
			text += "\n <tr>";
			for(int c = 0; c < _cols; c++){
				text += "\n <td> </td>";
			}			
		}
		text += "\n </table>";
	}
	
	
	/**
	 * Updates a file's text by replacing
	 */
	public void Apply(File file){
		buffer = file.getBuffer();
		file.setBuffer(buffer.substring(0,startPos) + text + buffer.substring(startPos));
	}
	
	
	/**
	 * Undoes the addition of text from a file
	 */
	public void Undo(File file){
		file.setBuffer(buffer);
	}
}
