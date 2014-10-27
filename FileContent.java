import java.util.ArrayList;
import java.util.List;


public class FileContent {
	private File activeFile;
	private List<File> fileList;
	
	public FileContent(){
		fileList = new ArrayList<File>();
	}

	/**
	 * Changes the the active file
	 */
	public void changeFile(int id){
		for(int i = 0; i < fileList.size(); i++){
			if(fileList.get(i).getID() == id){
				activeFile = fileList.get(i);
				return;
			}
		}
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
	 * Returns the start position of the highlighted string
	 * If there is no highlighted string, it returns the cursor position
	 */
	public int getCursorStart(){
		return activeFile.getCursorStart();
	}
		
	/**
	 * Returns the end position of the highlighted string
	 */
	public int getCursorEnd(){
		return activeFile.getCursorEnd();
	}
		
	/**
	 * Sets the cursor position
	 */
	public void setCursorStart(){
		
	}
	
}
