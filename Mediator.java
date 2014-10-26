
public class Mediator{

	private CommandBuilder builder;
	private FileHandler fileHandler;
	private PromptManager prompt;
	
	public Mediator(){
		builder = new CommandBuilder();
		fileHandler = new FileHandler();
		prompt = new PromptManager();
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
