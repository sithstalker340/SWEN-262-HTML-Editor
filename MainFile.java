
public class MainFile
{
	MenuView menu;
	MainView view;
	//ViewListener listener;
	Mediator mediator;
	InputHandler input;
	public MainFile()
	{
		mediator = new Mediator();
		view = new MainView(mediator);
		
		view.med = mediator;
		
		input = new InputHandler();
		//mediator.fileHandler.load("C:\\Users\\Adam\\Desktop\\TEMP_Important\\SWEN-262\\Editor 2\\test.txt");
<<<<<<< HEAD
		//mediator.fileHandler.save();
		//mediator.fileHandler.load("C:\\Users\\Adam\\Desktop\\TEMP_Important\\SWEN-262\\Editor 2\\test.txt");
=======
		mediator.fileHandler.save();
		mediator.fileHandler.load("C:\\Users\\Adam\\Desktop\\test1.html");
>>>>>>> 60a4d4b0a152a62286fffc0487eb1f7a96dc3800
		
	}
	
	public static void main(String args[]){
		MainFile main = new MainFile();
	}
}