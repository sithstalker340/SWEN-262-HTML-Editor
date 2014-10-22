import java.applet.Applet;

import javax.swing.JApplet;

public class MainFile extends Applet
{
	MainView view = new MainView();
	public MainFile()
	{

		this.setSize(400, 400);
		this.show();
		this.add(view);
		view.init(this);
	}
}