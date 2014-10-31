
public class MainFile
{
	MenuView menu;
	MainView view;
	Mediator mediator;
	InputHandler input;
	
	public MainFile()
	{
		mediator = new Mediator();
		view = new MainView(mediator);
		input = new InputHandler();
	}
	
	public static void main(String args[]){
		new MainFile();
	}
}