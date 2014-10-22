
public class Mediator {

	private CommandBuilder builder;
	private FileHandler fileHandler;
	
	public Mediator(){
		
	}
	
	/**
	 * Tells the builder to create a command and then pushes it to fileHandler.
	 */
	public void pushCommand(){
		builder.CreateCommand();
		fileHandler.pushCommand(null);
	}
	
	/**
	 * Updates the view.
	 */
	public void updateDisplay(){
		
	}
}
