import java.util.ArrayList;
import java.util.List;


public class FileContent {
	private File activeFile;
	private List<File> fileList = new ArrayList<File>();
	
	public FileContent(){
		
	}
	
	public void request(){
		
	}
	
	public void changeFile(){
		
	}
	
	public void pushCommand(Command cmd){
	}
		
	public void popCommand(){
	}
		
	public int getMouseStart(){
		return activeFile.getMouseStart();
	}
		
	public int getMouseEnd(){
		return activeFile.getMouseEnd();
	}
		
	public void setMouseStart(){
	}
	
}
