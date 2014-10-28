
public class CommandBuilder{

	public CommandBuilder(){
		
	}
	
	//Handles creation of commands 
	public Command CreateCommand(String text, int start, int end, String type){
		Command cmd;
		
		if(type == "Additive"){
			cmd = new AdditiveCommand(text,start,end);
		}else if(type == "Subtractive"){
			cmd = new SubtractiveCommand(text,start,end);
		}else{
			cmd = null;			
		}
		
		return cmd;
	}
}
