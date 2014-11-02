import javax.swing.JFileChooser;


public class InputHandler {

	private Mediator mediator; 
	public MainView mainView;
	final JFileChooser fc;
	
	public InputHandler(Mediator m){
		mediator = m;
		fc = new JFileChooser();
	}
	
	/**
	 * Handles the events fired from a button being pressed
	 * @param txt
	 */
	public void buttonViewInput(String txt){
		System.out.println(txt);
		switch(txt){
			case "<b>":
				System.out.println("BOLD TAG");
				break;
				
			case "<i>":
				System.out.println("ITALICS TAG");
				break;
				
			case "<a>":
				System.out.println("LINK TAG");
				break;
				
			case "<Header>":
				System.out.println("HEADER TAG");
				break;
		}
	}
	
	/**
	 * Handles the events fired from a menu selection
	 * @param txt
	 */
	public void menuViewInput(String txt){
		System.out.println(txt);
		switch(txt){
			case "Save":
				System.out.println("Save Clicked");
				
				if(getMediator().fileHandler.canSave()){
					if(getMediator().fileHandler.save() == true){
						
					}
					
					else menuViewInput("Save As...");
				}
				break;
				
			case "Save As...":				
				if(getMediator().fileHandler.canSave()){
					int returnVal = fc.showSaveDialog(fc);
					
					if(returnVal == JFileChooser.APPROVE_OPTION){
						java.io.File file = fc.getSelectedFile();
						String location = file.getPath().toString();
						
						getMediator().fileHandler.saveAs(location);
					}
				}
				break;
				
			case "Open File...":
				int returnVal = fc.showOpenDialog(fc);	
				
				if(returnVal == JFileChooser.APPROVE_OPTION){
					java.io.File file = fc.getSelectedFile();
					String name = file.getPath().toString();

					File openedFile = getMediator().fileHandler.load(name);
					System.out.println(openedFile.getBuffer());

					mainView.textView.resetLastCharIn();
					getMediator().setTextAreaString(openedFile.getBuffer());
				}
				
				else System.out.println("Error opening file");
			break;
			
			case "Exit":
				mediator.fileHandler.quit();
			break;
		}
	}
	
	/**
	 * Sets the mainView variable stored in InputHandler
	 * @param m
	 */
	public void setMainView(MainView m){
		mainView = m;
	}
	
	/**
	 * Returns the mediator variable stored in InputHandler
	 * @return
	 */
	public Mediator getMediator(){
		return mediator;
	}
}
