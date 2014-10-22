
public class Mediator {

	private CommandBuilder builder;
	private FileHandler fileHandler;
	
	public Mediator(){
		builder = new CommandBuilder();
		fileHandler = new FileHandler();
	}
	
	/**
	 * Tells the builder to create a command and then pushes it to fileHandler.
	 */
	public void pushCommand(){
		fileHandler.pushCommand(builder.CreateCommand());
	}
	
	/**
	 * Updates the view.
	 */
	public void updateDisplay(){
		
	}
}
