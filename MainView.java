import java.awt.FlowLayout;

import javax.swing.JFrame;


public class MainView extends JFrame
{
	MenuView menu;
	ViewListener listener;
	BtnView buttons = new BtnView();
	CardLayout cL = new CardLayout();
	
	public MainView()
	{
		//calls init
		this.init();
		//sets layout
		this.setLayout(new FlowLayout());
	}
	
	/**
	 * @param args
	 */
	public void init() 
	{
		//create menu Object
		menu = new MenuView(this);
		//create ViewListener
		listener = new ViewListener();
		//set Size of program
		this.setSize(400, 400);
		//makes program appear
		this.setVisible(true);
		//initialize menu
		menu.init(this, listener);
		//sets menu Object as the MenuBar
		this.setJMenuBar(menu);
		//Set program to exit on close
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}

}
