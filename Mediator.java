
public class Mediator{

	private CommandBuilder builder;
	public FileHandler fileHandler;
	private PromptHandler prompt;
	
	public Mediator(){
		builder = new CommandBuilder();
		fileHandler = new FileHandler();
		prompt = new PromptHandler();
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
