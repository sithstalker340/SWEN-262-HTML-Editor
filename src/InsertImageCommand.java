
public class InsertImageCommand extends Command {
	
	private String src;
	private int startPos;
	private int endPos;
	private String buffer;
	
	public InsertImageCommand(String src, int startPosition, int endPosition){
		this.src = src;
		startPos = startPosition;
		endPos = endPosition;
		this.isUndoable = true;
	}
	
	@Override
	public void Apply(File file) {
		buffer = file.getBuffer();
		file.setBuffer(buffer.substring(0,startPos) + "<img src=" + "\"" + src + "\"" + ">" + buffer.substring(startPos,endPos) + "</img>"+ buffer.substring(endPos));
		
	}

	@Override
	public void Undo(File file) {
		file.setBuffer(buffer);
	}
}
