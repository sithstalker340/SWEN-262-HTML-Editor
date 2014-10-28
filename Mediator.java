
public class Mediator{

	private CommandBuilder builder;
	public FileHandler fileHandler;
	
	public Mediator(){
		builder = new CommandBuilder();
		fileHandler = new FileHandler();
	}
	
	/**
	 * Tells the builder to create a command and then pushes it to fileHandler.
	 */
	public void pushCommand(String text, int start, int end, String type){
		fileHandler.pushCommand(builder.CreateCommand(text, start, end, type));
	}
	
	public void redoCommand(){
		fileHandler.redoCommand();
	}
	
	/**
	 * Updates the view.
	 */
	public void updateDisplay(){
		
	}
}
