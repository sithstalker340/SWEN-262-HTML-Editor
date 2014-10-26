import javax.swing.JFrame;

public class MainFile extends JFrame
{
	MenuView menu;
	MainView view;
	ViewListener listener;
	Mediator mediator;
	InputHandler input;
	public MainFile()
	{
		listener = new ViewListener();
		menu = new MenuView(this);
		view = new MainView(this);
		mediator = new Mediator();
		input = new InputHandler();
		this.setSize(400, 400);
		this.setVisible(true);
		menu.init(this, listener);
		this.add(menu);
		//x.setVisible(true);
		menu.setVisible(true);
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