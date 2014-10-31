
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
	 * Updates the view.
	 */
	public void updateDisplay(String s){
		mainView.textArea.setText(s); // should this create a command to perform this?
	}
	
	public String getMainViewText(){
		return mainView.textArea.getText().toString(); 	
	}
}
