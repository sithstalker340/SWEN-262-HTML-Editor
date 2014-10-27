
public abstract class Command {
	
	public boolean isUndoable;
	
	public abstract void Apply();
	
	public abstract void Undo();
}

