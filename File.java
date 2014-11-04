import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class File{
	private Deque<Command> commandStack;
	private Stack<Command> redoStack;
	private String buffer;
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
	
	public void setIsSaved(boolean b){
		isSaved = b;
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
		if(cmd == null){
			System.out.println("cmd is null");
			
		}
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
}
