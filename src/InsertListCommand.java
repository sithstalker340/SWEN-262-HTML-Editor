
public class InsertListCommand extends Command {
	private int numberRows;
	
	public InsertListCommand(String textString, int start, int numRows){
		text = textString;
		start = start;
		numberRows = numRows;
		isUndoable = true;
	}
	
	public void Apply(File file) {
		buffer = file.getBuffer();
		
	    StringBuilder builder = new StringBuilder();
	    builder.append("\n");
	    builder.append("<" + text + ">");
	    
		for(int i = 0; i < numberRows; i++){
			if(text == "dl"){
				builder.append('\n');
				builder.append("<dt>" + " " + "</dt>"); 
		        builder.append('\n');
		        builder.append("<dd>"  + " " + "</dd>");   
		    }

		    else{
		    	builder.append('\n');
		    	builder.append("<li>" + " " + "</li>");
		    }       
		}
		
		builder.append('\n');
	    builder.append("</" + text + ">");
	    
	    String newBuffer = buffer.substring(0,start) + builder.toString() + buffer.substring(start);
		file.setBuffer( newBuffer );
	}
	
	public void Undo(File file) {
		file.setBuffer(buffer);		
	}

}
