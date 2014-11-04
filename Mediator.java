
public class Mediator{

	private CommandBuilder builder;
	public FileHandler fileHandler;
	private MainView mainView;
	public PromptManager promptManager;
	
	public Mediator(){
		builder = new CommandBuilder(this);
		fileHandler = new FileHandler(this);
		promptManager = new PromptManager(mainView);
	}
	
	/**
	 * Sets the mainView variable stored in Mediator
	 * @param m
	 */
	public void setMainView(MainView m){
		mainView = m;
		if(mainView == null){
			System.out.println("MainView in Mediator is null.");
		}
	}
	
	/**
	 * Tells the builder to create a command and then pushes it to fileHandler.
	 */
	public void pushCommand(String text, int start, int end, String type){
		if(type != "Additive"){
			fileHandler.pushCommand(builder.CreateCommand(getMainViewText(), 0, getMainViewText().length(), "Additive"));
		}
		
		fileHandler.pushCommand(builder.CreateCommand(text, start, end, type));
	}
	
	/**
	 * Removes the most recent command
	 */
	public void popCommand(){
		fileHandler.popCommand();
	}
	
	/**
	 * Reapplies the most recently removed command
	 */
	public void redoCommand(){
		fileHandler.redoCommand();
	}

	
	/**
	 * Sets the current file's text box's text to the string parameter
	 * @param s
	 */
	public void setTextAreaString(String s){
		mainView.getCurrentTextView().textArea.setText(s);
		
	}
	
	/**
	 * Returns the text from the text box of the current file
	 * @return
	 */
	public String getMainViewText(){
		return mainView.getCurrentTextView().textArea.getText().toString();
	}	
}
