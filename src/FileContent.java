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
		
	public void redoCommand(){
		if(activeFile != null)
			activeFile.redoCommand();
	}
	
	public void addFile(File file){
		fileList.add(file);
	}
	
	public String getPath(){
		if(activeFile == null){
			return "";
		}
			
		return activeFile.getPath();
	}
	
	public String getBuffer(){
		if(activeFile == null){
			return "";
		}
		
		return activeFile.getBuffer();
	}
	
	public void setIsSaved(boolean b){
		if(activeFile == null){
			return;
		}
		
		activeFile.setIsSaved(b);
	}
	
	public boolean getIsSaved(){
		if(activeFile == null){
			return true;
		}
		
		return activeFile.isSaved();
	}
	
	public int getID(){
		if(activeFile == null){
			return -1;
		}
		
		return activeFile.getID();
	}
	
	public void setBuffer(String s){
		if( s != null && activeFile != null)
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
		return null;//File doesn't exist, return NULL
	}
	
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
	
	public void setPath( String path){
		if(activeFile != null)
			activeFile.setPath(path);
	}
}
