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
	
	public MainFile(String path)
	{
		this();
		
		String name = "";
		
		int lastPos = path.indexOf("\\");
		while(lastPos != -1){
			name = path.substring(lastPos + 1);
			lastPos = path.indexOf("\\", lastPos + 2);
		}
		
		mediator.openFile(name, path);
	}
	
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String args[]){
		if(args.length > 0 ){
			new MainFile(args[0]);
		}else{
			new MainFile();
		}
	}
}