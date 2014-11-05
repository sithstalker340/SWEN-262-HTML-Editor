import java.util.ArrayList;
import java.util.List;


public class FileContent {
	private File activeFile;
	private List<File> fileList;
	
	public FileContent(){
		fileList = new ArrayList<File>();
		activeFile = null;
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
	
	public String getPath(){
		return activeFile.getPath();
	}
	
	public String getBuffer(){
		return activeFile.getBuffer();
	}
	
	public void setIsSaved(boolean b){
		activeFile.setIsSaved(b);
	}
	
	public boolean getIsSaved(){
		return activeFile.isSaved();
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
	
	public void setIsFunctional(boolean b){
		if(activeFile == null){
			return;
		}
		activeFile.setIsFunctional(b);
	}
	
	public boolean getIsFunctional(){
		if(activeFile == null){
			return false;
		}
		
		return activeFile.getIsFunctional();
	}
	
	public File getFileByID(int id){
		for(File f : fileList){
			if(f.getID() == id){
				return f; //file is found, return the file
			}
		}
		return null; 		//File doesn't exist, return NULL
	}
}
