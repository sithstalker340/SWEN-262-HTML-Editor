
public class MainFile
{
	MenuView menu;
	MainView view;
	Mediator mediator;
	InputHandler input;
	
	public MainFile()
	{
		mediator = new Mediator();
		input = new InputHandler(mediator);
		view = new MainView(input);
	}
	
	public static void main(String args[]){
		new MainFile();
	}
}