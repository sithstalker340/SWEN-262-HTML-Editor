/**
 * Error Command that is send when a inserting command is canceled.
 * @author Andrew
 *
 */
public class ErrorCommand extends Command {
	
	public ErrorCommand(){
		this.isUndoable = false;
	}
	
	/**
	 * Is not used in this class.
	 */
	public void Apply(File file) {
		
	}

	/**
	 * Is not used in this class.
	 */
	public void Undo(File file) {
		
	}
}