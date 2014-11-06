public class Mediator{

	private CommandBuilder builder;
	private FileHandler fileHandler;
	private MainView mainView;
	public PromptManager promptManager;
	
	public Mediator(){
		builder = new CommandBuilder(this);
		fileHandler = new FileHandler(this);
	}
	
	/**
	 * Sets the mainView variable stored in Mediator
	 * @param m
	 */
	public void setMainView(MainView m){
		mainView = m;
		promptManager = new PromptManager(mainView);
	}
	
	/**
	 * Tells the builder to create a command and then pushes it to fileHandler.
	 */
	public void pushCommand(String text, String type){
		if(type == "Update"){
			fileHandler.pushCommand(builder.CreateCommand(text, 0, text.length(), "Additive"));
		}
		
		else if(type == "Subtractive"){
			fileHandler.pushCommand(builder.CreateCommand(mainView.getText(), 0, text.length(), "Subtractive"));
			
		}else{
			fileHandler.pushCommand(builder.CreateCommand(text, mainView.getCursorStart() , mainView.getCursorEnd(), type));
			
			if(type == "link"){
				updateLinkedView();
			}
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
		mainView.setText(s);
	}
	
	/**
	 * Returns the text from the text box of the current file
	 * @return
	 */
	public String getMainViewText(){
		return mainView.getText();
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
		mainView.quit();
	}
	
	public void openFile(String name, String path){
		File file = fileHandler.load(path);
		mainView.addTab(name, file.getID());
		setTextAreaString(file.getBuffer());
	}
	
	public void createNewFile(String name){
		File file = fileHandler.createNewFile(name);
		mainView.addTab(name, file.getID());
		setTextAreaString("");
	}
	
	public void changeCurrentFile(int id){
		fileHandler.changeCurrentFile(id);
	}
	
	public void setIsSaved(boolean b){
		fileHandler.setIsSaved(b);
	}
	
	public void createNewLinkedView(){
		int strategy;
		strategy = promptManager.displayChoice("Please select a formatted view.","Alphabetical","Appearance");
		if(strategy > -1){
			mainView.newLinkedView(strategy);
		}
	}
	 
	public void updateFileBuffer(){
		pushCommand(getMainViewText(), "Update");
	}
	
	public boolean getIsFunctional(){
		updateFileBuffer();
		return fileHandler.getIsFunctional();
	}
	
	public void setIsFunctional(){
		fileHandler.setIsFunctional();
	}
	
	public boolean closeTab(int id){
		return fileHandler.close(id);
	}
	
	public void updateTabName(String name){
		mainView.updateFileName(name);
	}
	
	public void updateLinkedView(){
		if(mainView.linkedView != null){
			updateFileBuffer();
			mainView.linkedView.updateLinkList(getMainViewText());
		}
	}
	
	public void toggleWordWrap(){
		mainView.toggleWordWrap();
	}
}
