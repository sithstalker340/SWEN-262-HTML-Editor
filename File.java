import java.util.Stack;

public class File{
	private Stack<Command> commandStack = new Stack<Command>(); 
	private String buffer;
	private int cursorStart;
	private int cursorEnd;
	
	/**
	 * The constructor of the File class.
	 */
	public File(){
		buffer = "";
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
	
	public int getCursorStart(){
		return cursorStart;
	}
	
	public int getCursorEnd(){
		return cursorEnd;
	}
	
	public void setMouseStart(){
	}
	
	
}
