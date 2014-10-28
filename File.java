import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;

public class File{
	private Deque<Command> commandStack;
	private String buffer;
	private int cursorStart;
	private int cursorEnd;
	private int id;
	private int stackSize;
	private Path location;
	private boolean isSaved;
	
	/**
	 * The constructor of the File class.
	 */
	public File(int idNum){
		commandStack = new ArrayDeque<Command>();
		buffer = "";
		cursorStart = 0;
		cursorEnd = 0;
		id = idNum;
		stackSize = 20;
		isSaved = true;
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
	
	public boolean isSaved(){
		return isSaved;
	}
	public void setPath(String p){
		location = Paths.get(p);
	}
	
	public void setBuffer(String s){
		buffer = s;
	}
	
  /**
   * Saves the command to the file and then applies the command.
   * @param cmd
   */
	public void pushCommand(Command cmd){
		cmd.Apply(this);
		if(cmd.isUndoable){
			commandStack.addFirst(cmd);
		}
		
		if(commandStack.size() > stackSize){
			commandStack.removeLast();
		}
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
