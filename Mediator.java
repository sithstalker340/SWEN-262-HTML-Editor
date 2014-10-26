
public class Mediator{

	private CommandBuilder builder;
<<<<<<< HEAD
	public FileHandler fileHandler;
	private PromptHandler prompt;
=======
	private FileHandler fileHandler;
	private PromptManager prompt;
>>>>>>> d267454b3165d05adb5664355cd9333f49a8946f
	
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
