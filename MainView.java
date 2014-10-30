import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class MainView extends JFrame
{
	MenuView menu;
	ViewListener listener;
	BtnView buttons;
	CardLayout cL = new CardLayout();
	JFrame frame;
	JTextArea txtArea;
	JPanel panel;
	
	public MainView(Mediator m)
	{	
		this.setLayout(new FlowLayout()); 
		this.setTitle("Editor");

		menu = new MenuView(this);
		listener = new ViewListener();
		this.setSize(700, 400);
		menu.init(this, listener);
		buttons = new BtnView(this, listener);
		listener.setMediator(m);		
		this.setJMenuBar(menu);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(buttons);
		
		//TODO mess with set up to get this to display properly.
		
		
		
		//makes program appear
		this.setVisible(true);
	}

}
