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
		int cursorStart = mainView.getCursorStart();
		
		if(type == "update"){
			fileHandler.pushCommand(builder.CreateCommand(mainView.getText(), 0, text.length(), "Additive"));
		}
		
		else if(type == "tagLayout"){
			fileHandler.pushCommand(builder.CreateCommand(mainView.getText(), 0, text.length(), "Additive"));
			text = fileHandler.getTagLayout();
			fileHandler.pushCommand(builder.CreateCommand(text, 0, text.length(), "Additive"));
			return;
		}
		
		else if(type == "Subtractive"){
			fileHandler.pushCommand(builder.CreateCommand(mainView.getText(), 0, text.length(), "Subtractive"));
			
		}
		
		else{
			//update display
			fileHandler.pushCommand(builder.CreateCommand(mainView.getText(), 0, text.length(), "Additive"));
			fileHandler.pushCommand(builder.CreateCommand(text, mainView.getCursorStart() , mainView.getCursorEnd(), type));
			
			if(type == "link"){
				updateLinkedView();
			}
		}		
		
		mainView.setCursorStart(cursorStart);
	}
	
	/**
	 * Removes the most recent command
	 */
	public void popCommand(){
		int cursorStart = mainView.getCursorStart();
		String mt = mainView.getText() ;
		String ft = fileHandler.getBuffer();
		if(!mt.equals(ft)){
			//update the backend before undoing
			pushCommand("", "update");
		}
		fileHandler.popCommand();
		mainView.setCursorStart(cursorStart);
	}
	
	/**
	 * Reapplies the most recently removed command
	 */
	public void redoCommand(){
		int cursorStart = mainView.getCursorStart();
		fileHandler.redoCommand();
		mainView.setCursorStart(cursorStart);
	}

	/**
	 * Sets the current file's text box's text to the string parameter
	 * @param s
	 */
	public void setTextAreaString(String s){
		//TODO eval removing this
		mainView.setText(s);
	}
	
	/**
	 * Returns the text from the text box of the current file
	 * @return
	 */
	public String getMainViewText(){
		//TODO eval why this would be needed
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
		//TODO eval why this exists.  
		pushCommand(getMainViewText(), "update");
	}
	
	public boolean getIsFunctional(){
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
