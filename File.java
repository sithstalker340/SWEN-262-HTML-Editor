import java.util.Stack;

public class File{
	private Stack<Command> commandStack = new Stack<Command>(); 
	private String buffer;
	private int cursorStart;
	private int cursorEnd;
	
	/**
	 * The constructor of the File class.
	 */
	public File(String b){
		buffer = b;
		cursorStart = 0;
		cursorEnd = 0;
	}
  
  /**
   * Saves the command to the file and then applies the command.
   * @param cmd
   */
	public void pushCommand(Command cmd){
	}
	
	/**
	 * Removes and undos the command.
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
