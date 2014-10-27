
public class AdditiveCommand extends Command{
	
	private String text;
	private int startPos;
	private int endPos;
	
	
	public AdditiveCommand(String textString, int startPosition, int endPosition){
		text = textString;
		startPos = startPosition;
		endPos = endPosition;
		
		if(endPos == startPos){
			endPos = startPos + text.length();
		}
	}
	
	public void Apply(File file){
		String buffer = file.getBuffer();
		file.setBuffer(buffer.substring(0,startPos) + text + buffer.substring(endPos));
	}
	
	public void Undo(File file){
		String buffer = file.getBuffer();
		file.setBuffer(buffer.substring(0, startPos) + buffer.substring(endPos));
	}
}
