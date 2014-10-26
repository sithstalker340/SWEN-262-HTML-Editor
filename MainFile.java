
public class MainFile
{
	MenuView menu;
	MainView view;
	//ViewListener listener;
	Mediator mediator;
	InputHandler input;
	public MainFile()
	{
		view = new MainView();
		mediator = new Mediator();
		input = new InputHandler();
		mediator.fileHandler.load("C:\\Users\\Adam\\Desktop\\TEMP_Important\\SWEN-262\\Editor 2\\test.txt");
		
		
	}
	
	public static void main(String args[]){
		MainFile main = new MainFile();
	}
}