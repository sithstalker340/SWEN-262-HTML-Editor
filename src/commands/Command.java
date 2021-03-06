package commands;
import editor.File;

/**
 * Abstract class for the Command classes.
 * @author Braxton.
 *
 */
public abstract class Command {
	
	public boolean isUndoable;
	protected String text;
	protected String buffer;
	protected int start;
	protected int end;
	
	public abstract void Apply(File file);
	
	public abstract void Undo(File file);
}

