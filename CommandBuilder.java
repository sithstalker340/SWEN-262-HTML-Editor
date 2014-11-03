

public class CommandBuilder{
	private Mediator mediator;
	
	public CommandBuilder(Mediator _m){
		mediator = _m;
	}
	
	//Handles creation of commands 
	public Command CreateCommand(String text, int start, int end, String type){
		Command cmd;
		
		if(type == "Additive"){
			cmd = new AdditiveCommand(text,start,end);
		}
		else if(type == "Subtractive"){
			cmd = new SubtractiveCommand(text,start,end);	
		}
		else if(type == "Tag"){
			cmd = new InsertTagCommand(text, start, end);
		}
		else if(type == "Link"){
			//prompt user for link url
			cmd = new InsertTagCommand(text, start, end);
		}
		else if(type == "List"){
			//prompt user for number of items in list
			cmd = new InsertTagCommand(text, start, end);
		}		
		else if(type == "Table"){
			//prompt user for number of rows and columns 
			cmd = new InsertTagCommand(text, start, end);
		}		
		else{
			cmd = null;			
		}
		
		return cmd;
	}
}
