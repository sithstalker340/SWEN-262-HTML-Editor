import java.awt.FlowLayout;

import javax.swing.JFrame;


public class MainView extends JFrame
{
	MenuView menu;
	ViewListener listener;
	BtnView buttons;
	CardLayout cL = new CardLayout();
	
	public MainView()
	{
		//calls init
		this.init();
		//sets layout
		this.setLayout(new FlowLayout());
		//sets Title
		this.setTitle("Editor");
	}
	
	/**
	 * @param args
	 */
	public void init() 
	{
		//create menu Object
		menu = new MenuView(this);
		//create ButtonView Object
		buttons = new BtnView();
		//create ViewListener
		listener = new ViewListener();
		//set Size of program
		this.setSize(700, 400);
		//initialize menu
		menu.init(this, listener);
		//initialize buttons
		buttons.init(this, listener);
		//sets menu Object as the MenuBar
		this.setJMenuBar(menu);
		//Set program to exit on close
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Adds the btnView Object
		this.add(buttons);
		//makes program appear
		this.setVisible(true);
	}

}
