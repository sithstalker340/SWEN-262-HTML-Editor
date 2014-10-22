import java.applet.Applet;

import javax.swing.JApplet;

public class MainFile extends Applet
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
		this.show();
		this.add(view);
		view.init(this);
	}
}