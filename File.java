import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

public class File{
	private Stack<Command> commandStack;
	private String buffer;
	private int cursorStart;
	private int cursorEnd;
	private int id;
	private Path location;
	
	/**
	 * The constructor of the File class.
	 */
	public File(int idNum){
		commandStack = new Stack<Command>();
		buffer = "";
		cursorStart = 0;
		cursorEnd = 0;
		id = idNum;
	}
	public File(String b,int idNum){
		this(idNum);
		buffer = b;
	}
  
	public int getID(){
		return id;
	}
	
	public Path getPath(){
		return location;
	}
	
	public String getBuffer(){
		return buffer;
	}
	
	public void setPath(String p){
		Path path = Paths.get(p);
	}
	
  /**
   * Saves the command to the file and then applies the command.
   * @param cmd
   */
	public void pushCommand(Command cmd){
	}
	
	/**
	 * Removes and undo's the command.
	 */
	public void popCommand(){
	}
	
	/**
	 * Returns the position of the cursor
	 */
	public int getCursorStart(){
		return cursorStart;
	}
	
	/**
	 * Returns the end position of the highlighted string
	 * If there is no highlighted string, returns the cursor position
	 */
	public int getCursorEnd(){
		return cursorEnd;
	}
	
	/**
	 * Sets the cursor position
	 */
	public void setCursorStart(){
		
	}	
}
