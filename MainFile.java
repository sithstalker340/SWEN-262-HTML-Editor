import javax.swing.JFrame;

public class MainFile extends JFrame
{
	MainView view;
	Mediator mediator;
	InputHandler input;
	public MainFile()
	{
		view  = new MainView(this);
		mediator = new Mediator();
		input = new InputHandler();
		this.setSize(400, 400);
		this.setVisible(true);
		this.add(view);
		//view.init(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.paintComponents(getGraphics());
	}
	
	public static void main(String args[])
	{
		MainFile frame = new MainFile();
	}
	
	
}