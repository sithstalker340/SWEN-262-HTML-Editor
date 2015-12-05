package editor;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import commands.Command;

/**
 * Holds all of the users text.
 * @author Adam, Braxton, Andrew
 *
 */
public class File{
	private Deque<Command> commandStack;
	private Stack<Command> redoStack;
	private String buffer;
	private int id;
	private int stackSize;
	private String location;
	private boolean isSaved;
	private boolean isFunctional;
	
	/**
	 * The constructor of the File class.
	 * @param int
	 */
	public File(int idNum){
		commandStack = new ArrayDeque<Command>();
		redoStack = new Stack<Command>();
		buffer = "";
		id = idNum;
		stackSize = 20;
		isSaved = false;
		isFunctional = false;
	}
	
	/**
	 * Overloaded Constructor of the File class.
	 * @param b
	 * @param idNum
	 */
	public File(String b,int idNum){
		this(idNum);
		buffer = b;
	}
  
	/**
	 * Returns the id of the File.
	 * @return
	 */
	public int getID(){
		return id;
	}
	
	/**
	 * Returns the location of the File.
	 * @return
	 */
	public String getPath(){
		return location;
	}
	
	/**
	 * Returns the buffer of the File.
	 * @return
	 */
	public String getBuffer(){
		return buffer;
	}
	
	/**
	 * Boolean that checks to see if the File has been saved.
	 * @return
	 */
	public boolean isSaved(){
		return isSaved;
	}
	
	/**
	 * Sets whether the File was saved.
	 * @param b
	 */
	public void setIsSaved(boolean b){
		isSaved = b;
	}
	
	/**
	 * Sets the location of the File.
	 * @param p
	 */
	public void setPath(String p){
		location = p;
	}
	
	/**
	 * Sets the buffer of the File.
	 * @param s
	 */
	public void setBuffer(String s){
		buffer = s;
	}
	
  /**
   * Saves the command to the file and then applies the command.
   * @param cmd
   */
	public void pushCommand(Command cmd){
		this.pushCommand(cmd, true);
	}
	
	public void pushCommand(Command cmd, boolean clear){
		if(cmd == null){
			System.out.println("cmd is null");
			return;
		}
		cmd.Apply(this);
		if(cmd.isUndoable){
			commandStack.addFirst(cmd);
			if(clear){
				redoStack.clear();
			}
		}
		
		if(commandStack.size() > stackSize){
			commandStack.removeLast();
		}
	}
	
	/**
	 * Removes and undo's the command.
	 */
	public void popCommand(){
		if(!commandStack.isEmpty()){
			commandStack.getFirst().Undo(this);
			redoStack.push(commandStack.getFirst());
			commandStack.pop();
		}
	}
	
	/**
	 * Redo's the recently undone command.
	 */
	public void redoCommand(){
		if(redoStack.size() == 0){return;}
		
		this.pushCommand(redoStack.pop(), false); 
	}
	
	/**
	 * Well Formed Check.
	 * @return
	 */
	public boolean getIsFunctional(){
		return isFunctional;
	}
	
	/**
	 * Sets whether the File is well formed.
	 * @param b
	 */
	public void setIsFunctional(boolean b){
		isFunctional = b;
	}
}
