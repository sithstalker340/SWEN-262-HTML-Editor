
public class FileHandler {
	private FileContent mainFileContent;
	
	public FileHandler(){
		mainFileContent = new FileContent();
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
	 * @return bool
	 */
	public boolean wellFormed(){
		return true;
	}
	
	/**
	 * Prompts to save any unsaved work, and then exits the program
	 */
	public void quit(){
		
	}	
}
