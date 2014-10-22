
public class Mediator{

	private CommandBuilder builder;
	private FileHandler fileHandler;
	private Prompt prompt;
	
	public Mediator(){
		builder = new CommandBuilder();
		fileHandler = new FileHandler();
		prompt = new Prompt();
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
