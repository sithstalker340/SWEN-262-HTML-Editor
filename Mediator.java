
public class Mediator{

	private CommandBuilder builder;
	public FileHandler fileHandler;
	private MainView mainView;
	
	public Mediator(){
		builder = new CommandBuilder();
		fileHandler = new FileHandler();
	}
	
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
	
	public void popCommand(){
		fileHandler.popCommand();
	}
	
	public void redoCommand(){
		fileHandler.redoCommand();
	}
	
	/**
	 * Updates the current file's buffer
	 */
	public void updateFileBuffer(String s){
		fileHandler.updateFileBuffer(s);
	}
	
	public void setTextAreaString(String s){
		mainView.textView.textArea.setText(s);
	}
	
	public String getMainViewText(){
		return mainView.textView.textArea.getText().toString(); 	
	}
}
