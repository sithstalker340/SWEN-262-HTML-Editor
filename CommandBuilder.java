

public class CommandBuilder{
	private Mediator mediator;
	
	public CommandBuilder(Mediator _m){
		mediator = _m;
	}
	
	//Handles creation of commands 
	public Command CreateCommand(String text, int start, int end, String type){
		Command cmd;
		
		int temp = start;
		if(start > end){
			start = end;
			end = temp;
		}
		
		if(type == "Additive"){
			cmd = new AdditiveCommand(text,start,end);
		}
		else if(type == "Subtractive"){
			cmd = new SubtractiveCommand(text,start,end);	
		}
		else if(type == "tag"){
			cmd = new InsertTagCommand(text, start, end);
		}
		else if(type == "link"){
			cmd = new InsertLinkCommand(mediator.promptManager.displayLines1("Enter the url:"), start, end);
		}
		else if(type == "list"){
			cmd = new InsertListCommand(text, start,  Integer.parseInt(mediator.promptManager.displayLines1("How many items do you want in your list?")));
		}		
		else if(type == "table"){
			String[] userInput = new String[2];
			userInput = mediator.promptManager.displayLines2("Number of rows:", "Number of columns:"); 
			cmd = new InsertTableCommand(start, Integer.parseInt(userInput[0]), Integer.parseInt(userInput[1]));
		}		
		else if(type == "img"){
			cmd = new InsertImageCommand(mediator.promptManager.displayLines1("Enter the source path:"), start, end);
		}
		else{
			cmd = null;			
		}
		
		return cmd;
	}
}
