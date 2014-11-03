

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
			cmd = new InsertTagCommand( mediator.promptManager.displayLines1("Please enter your url:"), start, end);
		}
		else if(type == "List"){
			cmd = new InsertTagCommand(text, start,  Integer.parseInt(mediator.promptManager.displayLines1("How many items do you want in your list?")));
		}		
		else if(type == "Table"){
			String[] userInput = mediator.promptManager.displayLines2("Number of rows:", "Number of columns:"); 
			cmd = new InsertTableCommand(start, Integer.parseInt(userInput[0]), Integer.parseInt(userInput[1]));
		}		
		else{
			cmd = null;			
		}
		
		return cmd;
	}
}
