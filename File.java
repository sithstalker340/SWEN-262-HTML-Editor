import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class File{
	private Deque<Command> commandStack;
	private Stack<Command> redoStack;
	private String buffer;
	private int cursorStart;
	private int cursorEnd;
	private int id;
	private int stackSize;
	private String location;
	private boolean isSaved;
	
	/**
	 * The constructor of the File class.
	 */
	public File(int idNum){
		commandStack = new ArrayDeque<Command>();
		redoStack = new Stack<Command>();
		buffer = "";
		cursorStart = 0;
		cursorEnd = 0;
		id = idNum;
		stackSize = 20;
		isSaved = false;
	}
	
	public File(String b,int idNum){
		this(idNum);
		buffer = b;
	}
  
	public int getID(){
		return id;
	}
	
	public String getPath(){
		return location;
	}
	
	public String getBuffer(){
		return buffer;
	}
	
	public boolean isSaved(){
		return isSaved;
	}
	
	public void setIsSaved(){
		if(isSaved){
			isSaved = false;
		}
		
		else isSaved = true;
	}
	
	public void setPath(String p){
		location = p;
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
			redoStack.clear(); 
		}
		
		if(commandStack.size() > stackSize){
			commandStack.removeLast();
		}
	}
	
	/**
	 * Removes and undo's the command.
	 */
	public void popCommand(){
		commandStack.getFirst().Undo(this);
		redoStack.push(commandStack.getFirst());
		commandStack.pop();
	}
	
	public void redoCommand(){
		this.pushCommand(redoStack.pop()); 
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
