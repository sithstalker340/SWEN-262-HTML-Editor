import java.util.ArrayList;
import java.util.List;

/**
 * Allows the FileHandler to treat FileContent as a File object.
 * @author Braxton, Andrew, Adam
 *
 */
public class FileContent {
	private File activeFile;
	private List<File> fileList;
	
	/**
	 * Constructor of the FileContent class.
	 */
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
		if(activeFile != null)
			activeFile.pushCommand(cmd);
	}
		
	/**
	 * Undoes the most recent command of the active file
	 */
	public void popCommand(){
		if(activeFile != null)
			activeFile.popCommand();
	}
		
	/**
	 * Redo's the recently undone command.
	 */
	public void redoCommand(){
		if(activeFile != null)
			activeFile.redoCommand();
	}
	
	/**
	 * Adds a new file to the file list.
	 * @param file
	 */
	public void addFile(File file){
		fileList.add(file);
	}
	
	/**
	 * Returns the active files location.
	 * @return
	 */
	public String getPath(){
		if(activeFile == null){
			return "";
		}
			
		return activeFile.getPath();
	}
	
	/**
	 * Returns the active files buffer.
	 * @return
	 */
	public String getBuffer(){
		if(activeFile == null){
			return "";
		}
		
		return activeFile.getBuffer();
	}
	
	/**
	 * Set's whether the active file has been saved.
	 * @param b
	 */
	public void setIsSaved(boolean b){
		if(activeFile == null){
			return;
		}
		
		activeFile.setIsSaved(b);
	}
	
	/**
	 * Return's whether the active file has been saved.
	 * @return
	 */
	public boolean getIsSaved(){
		if(activeFile == null){
			return true;
		}
		
		return activeFile.isSaved();
	}
	
	/**
	 * Returns the active files id.
	 * @return
	 */
	public int getID(){
		if(activeFile == null){
			return -1;
		}
		
		return activeFile.getID();
	}
	
	/**
	 * Sets the active files buffer.
	 * @param s
	 */
	public void setBuffer(String s){
		if( s != null && activeFile != null)
			activeFile.setBuffer(s);
	}
	
	/**
	 * Returns the active file.
	 * @return
	 */
	public File getActiveFile(){
		return activeFile;
	}
	
	/**
	 * Sets whether the active file is well formed.
	 * @param b
	 */
	public void setIsFunctional(boolean b){
		if(activeFile == null){
			return;
		}
		
		activeFile.setIsFunctional(b);
	}
	
	/**
	 * Returns whether the active file is well formed.
	 * @return
	 */
	public boolean getIsFunctional(){
		if(activeFile == null){
			return false;
		}
		
		return activeFile.getIsFunctional();
	}
	
	/**
	 * Finds file by id. Returns File.
	 * @param id
	 * @return
	 */
	public File getFileByID(int id){
		for(File f : fileList){
			if(f.getID() == id){
				return f; //file is found, return the file
			}
		}
		return null;//File doesn't exist, return NULL
	}
	
	/**
	 * Removes file from list.
	 * @param file
	 */
	public void removeFile(File file){
		if(activeFile == null){
			return;
		}
		
		fileList.remove(file);
		if( activeFile == file ){
			activeFile = null;
			
			if(fileList.size() > 0){
				activeFile = fileList.get( fileList.size() - 1 ); //most recently added file is now the active file
			}
			
		}
	}
	
	/**
	 * Sets location of active file.
	 * @param path
	 */
	public void setPath( String path){
		if(activeFile != null)
			activeFile.setPath(path);
	}
}
