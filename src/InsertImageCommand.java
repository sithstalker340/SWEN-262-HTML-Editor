
public class InsertImageCommand extends Command {
	
	public InsertImageCommand(String src, int startPosition, int endPosition){
		text = src;
		start = startPosition;
		end = endPosition;
		isUndoable = true;
	}
	
	@Override
	public void Apply(File file) {
		buffer = file.getBuffer();
		String newBuffer = buffer.substring(0,start) + "<img src=" + "\"" + text + "\"" + ">" + buffer.substring(start,end) + "</img>"+ buffer.substring(end); 
		file.setBuffer(newBuffer);
	}

	@Override
	public void Undo(File file) {
		file.setBuffer(buffer);
	}
}
