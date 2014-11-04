

public class CommandBuilder{
	private Mediator mediator;
	
	public CommandBuilder(Mediator _m){
		mediator = _m;
	}
	
	//Handles creation of commands 
	public Command CreateCommand(String text, int start, int end, String type){
		Command cmd;
		
		System.out.println("Start: " + start);
		System.out.println("End: " + end);
		
		int temp = start;
		if(start > end){
			start = end;
			end = temp;
		}
		
		System.out.println("Start: " + start);
		System.out.println("End: " + end);
		
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
			//prompt user for link url
			cmd = new InsertTagCommand( mediator.promptManager.displayLines1("Please enter your url:"), start, end);
		}
		else if(type == "list"){
			cmd = new InsertTagCommand(text, start,  Integer.parseInt(mediator.promptManager.displayLines1("How many items do you want in your list?")));
		}		
		else if(type == "table"){
			String[] userInput = mediator.promptManager.displayLines2("Number of rows:", "Number of columns:"); 
			cmd = new InsertTableCommand(start, Integer.parseInt(userInput[0]), Integer.parseInt(userInput[1]));
		}		
		else{
			cmd = null;			
		}
		
		return cmd;
	}
}
