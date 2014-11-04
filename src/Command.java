
public abstract class Command {
	
	public boolean isUndoable;
	
	public abstract void Apply(File file);
	
	public abstract void Undo(File file);
}

