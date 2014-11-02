import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class FileContent {
	private File activeFile;
	private List<File> fileList;
	
	public FileContent(){
		fileList = new ArrayList<File>();
		activeFile = new File(0);
		addFile(activeFile);
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
		activeFile.pushCommand(cmd);
	}
		
	/**
	 * Undoes the most recent command of the active file
	 */
	public void popCommand(){
		activeFile.popCommand();
	}
		
	public void redoCommand(){
		activeFile.redoCommand();
	}
	
	public void addFile(File file){
		fileList.add(file);
	}
	
	public Path getPath(){
		return activeFile.getPath();
	}
	
	public String getBuffer(){
		return activeFile.getBuffer();
	}
	
	public int getID(){
		return activeFile.getID();
	}
	
	public void setBuffer(String s){
		activeFile.setBuffer(s);
	}
	
	public File getActiveFile(){
		return activeFile;
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
