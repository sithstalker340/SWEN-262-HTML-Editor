
public class InsertListCommand extends Command {
	
	public InsertListCommand(String tag, int start, int numRows){
		text = "";
		text += '<' + tag + '>';
		
		for(int i = 0; i < numRows; i++){
			text += '\n';
			
			if(tag == "dl"){
				text += "<dt> </dt>" + '\n' + "<dd> </dd>";
			}else{
				text += "<li> </li>";				
			}
		}
		
		text += '\n' + "<" + tag + ">";	
		
		this.start = start;
		isUndoable = true;
	}
	
	public void Apply(File file) {
		buffer = file.getBuffer();
		
	    String newBuffer = buffer.substring(0,start) + text + buffer.substring(start);
	    
		file.setBuffer( newBuffer );
	}
	
	public void Undo(File file) {
		file.setBuffer(buffer);		
	}

}
