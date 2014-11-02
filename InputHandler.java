import javax.swing.JFileChooser;


public class InputHandler {

	private Mediator mediator; 
	public MainView mainView;
	final JFileChooser fc;
	
	public InputHandler(Mediator m){
		mediator = m;
		fc = new JFileChooser();
	}
	
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
	
	public void menuViewInput(String txt){
		System.out.println(txt);
		switch(txt){
			case "Save":
				System.out.println("Save Clicked");
				
				if(getMediator().fileHandler.canSave()){
					getMediator().fileHandler.save();
				}
				break;
				
			case "Open File...":
				//System.out.println("Open File...");
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
				System.exit(0);
			break;
		}
	}
	
	public void setMainView(MainView m){
		mainView = m;
	}
	
	public Mediator getMediator(){
		return mediator;
	}
}
