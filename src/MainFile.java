/**
 * The main file for the Editor Project.
 * @author ALL
 *
 */
public class MainFile
{
	MenuView menu;
	MainView view;
	Mediator mediator;
	InputHandler input;
	
	/**
	 * The constructor of the MainFile class.
	 */
	public MainFile()
	{
		mediator = new Mediator();
		input = new InputHandler(mediator);
		view = new MainView(input);
		mediator.setMainView(view);
	}
	
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String args[]){
		new MainFile();
	}
}