import java.util.Stack;

public class File{
	private Stack<Command> commandStack = new Stack<Command>(); 
	private String buffer;
	private int mouseStart;
	private int mouseEnd;
	
	/**
	 * The constructor of the File class.
	 */
	public File(){
		buffer = "";
		mouseStart = 0;
		mouseEnd = 0;
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
	
	public int getMouseStart(){
		return mouseStart;
	}
	
	public int getMouseEnd(){
		return mouseEnd;
	}
	
	public void setMouseStart(){
	}
	
	
}
