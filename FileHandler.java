import java.util.Arrays;
import java.util.Stack;


public class FileHandler {
	private FileContent mainFileContent;
	
	public FileHandler(){
		
	}
	
	/**
	 * Sends the parameter command to the active file
	 * @param cmd
	 */
	public void pushCommand(Command cmd){
	}
		
	/**
	 * Undoes the most recent command of the active file
	 */
	public void popCommand(){
	}
	
	/**
	 * Saves the active file
	 */
	public void save(){
		
	}
	
	/**
	 * Prompts the user to save the file with a desired name and location
	 */
	public void saveAs(){
		
	}
	
	/**
	 * Loads a file from the location specified in the parameter
	 * @param loc
	 * @return null
	 */
	public File load(String loc){
		return null;
	}
	
	/**
	 * Checks to see if the text in the current file is valid HTML
	 * @return boolean
	 */
	public boolean wellFormed(){
		Stack<String> tagStack = new Stack<String>();
		String allText = mainFileContent.toString(); // the buffer from the file
		
		int start = allText.indexOf('<');
		int end = allText.indexOf('>');
		String tag = "";
		
		if(start == -1 || end == -1){
			if(start == -1 && end == -1){
				return true;
			}
			
			return false;
		}
		
		while(start != -1 && end != -1){
			tag = allText.substring(start + 1, end);
			
			if(tag.indexOf(0) == '/'){
				tag = tag.substring(1);
				
				if(tagStack.peek() == tag){
					tagStack.pop();
				}
				
				else{
					return false;
				}
			}
			
			else{
				int endIndex = allText.indexOf(' ');
				if(endIndex == -1){
					tag = tag.substring(0, endIndex);
				}
				
				if(tag.indexOf(0) != '!'){
					tagStack.push(tag);
				}
			}
			
			allText = allText.substring(end + 1);
			start = allText.indexOf('<');
			end = allText.indexOf('>');
		}
		
		if(tagStack.size() != 0 && checksSelfClose(tag)){
			return false;
		}
		
		return true;
	}
	
	private boolean checksSelfClose(String tag){
		String[] selfClosing = {"meta", "link", "input"};
		
		if(Arrays.asList(selfClosing).indexOf(tag) > -1){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Prompts to save any unsaved work, and then exits the program
	 */
	public void quit(){
		
	}	
}
