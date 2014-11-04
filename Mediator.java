
public class Mediator{

	private CommandBuilder builder;
	private FileHandler fileHandler;
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
	}
	
	/**
	 * Tells the builder to create a command and then pushes it to fileHandler.
	 */
	public void pushCommand(String text, String type){
		fileHandler.pushCommand(builder.CreateCommand(getMainViewText(), 0, getMainViewText().length(), "Additive"));
		
		if(type != "Additive"){
			fileHandler.pushCommand(builder.CreateCommand(text, mainView.getCurrentTextView().getCursorStart() , mainView.getCurrentTextView().getCursorEnd(), type));
		}		
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
	
	public boolean canSave(){
		return fileHandler.canSave();
	}
	
	public boolean save(){
		return fileHandler.save();
	}
	
	public void saveAs(String path){
		fileHandler.saveAs(path);
	}
	
	public void quit(){
		fileHandler.quit();		
	}
	
	public void openFile(String name, String path){
		File file = fileHandler.load(path);
		mainView.addTab(name, file.getID());
		setTextAreaString(file.getBuffer());
	}
}
