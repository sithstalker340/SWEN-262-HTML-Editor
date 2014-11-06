
public class InsertTableCommand extends Command {
	
	public InsertTableCommand(int startPosition, int _rows, int _cols){
		start = startPosition;
		
		//construct table
		text = "<table>";
		for(int r = 0; r < _rows; r++){
			text += "\n <tr>";
			for(int c = 0; c < _cols; c++){
				text += "\n <td> </td>";
			}			
		}
		text += "\n </table>";
		isUndoable = true;
	}
	
	
	/**
	 * Updates a file's text by replacing
	 */
	public void Apply(File file){
		buffer = file.getBuffer();
		String newBuffer = buffer.substring(0,start) + text + buffer.substring(start);
		file.setBuffer(newBuffer);
	}
	
	/**
	 * Undoes the addition of text from a file
	 */
	public void Undo(File file){
		file.setBuffer(buffer);
	}
}
