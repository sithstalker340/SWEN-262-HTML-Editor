/**
 * Builds all of the concrete command classes.
 * @author Braxton
 *
 */
public class CommandBuilder{
	private Mediator mediator;
	
	public CommandBuilder(Mediator _m){
		mediator = _m;
	}
	
	/**
	 * Handles creation of commands 
	 * @param text
	 * @param start
	 * @param end
	 * @param type
	 * @return Command
	 */
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
			String s = mediator.promptManager.displayLines1("Enter the url:");
			if(s != ""){
				cmd = new InsertLinkCommand(s, start, end);	
			}
			else cmd = new ErrorCommand(); //do nothing
		}
		
		else if(type == "list"){
			
			String s = mediator.promptManager.displayLines1("Enter the number of list elements:");
			if(s != ""){
				try{
					int i = Integer.parseInt(s); 
					cmd = new InsertListCommand(text, start, i);
				}
				catch(Exception e){
					cmd = new ErrorCommand(); //do nothing
				}
			}
			
			else cmd = new ErrorCommand(); //this intentionally does nothing, cmd must be returned 
		}			
		
		else if(type == "table"){
			String[] userInput = new String[2];
			userInput = mediator.promptManager.displayLines2("Number of rows:", "Number of columns:"); 
		
			try{
				int i = Integer.parseInt(userInput[0]);
				int j = Integer.parseInt(userInput[1]);
				cmd = new InsertTableCommand(start, i, j);
			}
			
			catch(Exception e){
				cmd = new ErrorCommand(); //do nothing
			}
		}
		
		else if(type == "img"){
			String s = mediator.promptManager.displayLines1("Enter the source path:");
			if(s != ""){
				cmd = new InsertImageCommand(s, start, end);	
			}
			else cmd = new ErrorCommand(); //do nothing
		}
		
		else{
			cmd = null;			
		}
		
		return cmd;
	}
}
