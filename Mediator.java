
public class Mediator{

	private CommandBuilder builder;
	public FileHandler fileHandler;
	private MainView mainView;
	
	public Mediator(){
		builder = new CommandBuilder();
		fileHandler = new FileHandler();
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
	 * Updates the current file's buffer
	 */
	public void updateFileBuffer(String s){
		fileHandler.updateFileBuffer(s);
	}
	
	/**
	 * Sets the current file's text box's text to the string parameter
	 * @param s
	 */
	public void setTextAreaString(String s){
		mainView.textView.textArea.setText(s);
	}
	
	/**
	 * Returns the text from the text box of the current file
	 * @return
	 */
	public String getMainViewText(){
		return mainView.textView.textArea.getText().toString(); 	
	}
}
