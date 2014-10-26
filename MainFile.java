import javax.swing.JFrame;

public class MainFile extends JFrame
{
	MainView view;
	Mediator mediator;
	InputHandler input;
	public MainFile()
	{
		view  = new MainView();
		mediator = new Mediator();
		input = new InputHandler();
		this.setSize(400, 400);
		this.setVisible(true);
		this.add(view);
		view.init(this);
		mediator.fileHandler.load("C:\\Users\\Adam\\Desktop\\TEMP_Important\\SWEN-262\\Editor 2\\test.txt");
	}
}