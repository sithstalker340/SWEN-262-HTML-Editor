
public class InsertListCommand extends Command {

	private String text;
	private int startPos;
	private int endPos;
	private int numberRows;
	private String buffer;
	
	public InsertListCommand(String textString, int startPosition, int endPosition, int numRows){
		text = textString;
		startPos = startPosition;
		endPos = endPosition;
		numberRows = numRows;
	}
	
	public void Apply(File file) {
		buffer = file.getBuffer();
	    StringBuilder builder = new StringBuilder();
	    builder.append("\n");
	    builder.append("</" + text + ">");
	    
		for(int i = 0;i < numberRows;i+=1){
			if(text == "dl"){
				builder.append("\n");
				builder.append("<dt>" + " " + "</dt>"); 
		        builder.append("\n");
		        builder.append("<dd>"  + " " + "</dd>");   
		    }

		    else{
		    	builder.append("\n");
		    	builder.append("<li>" + " " + "</li>");
		    }       
		}
		file.setBuffer(buffer.substring(0,startPos) + builder.toString() + buffer.substring(endPos));
	}

	
	public void Undo(File file) {
		
		
	}

}
