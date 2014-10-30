import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class MainView extends JFrame
{
	MenuView menu;
	ViewListener listener;
	BtnView buttons;
	CardLayout cL;
	JFrame frame;
	JTextArea txtArea;
	JPanel panel;
	
	public MainView(Mediator m)
	{	
		this.setLayout(new FlowLayout()); 
		this.setTitle("Editor");

		cL = new CardLayout();
		listener = new ViewListener();
		listener.setMediator(m);
		
		menu = new MenuView(this, listener);
		menu.init(this, listener);
		buttons = new BtnView(this, listener);
		
		this.setSize(700, 400);
		this.setJMenuBar(menu);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(buttons);
		
		//TODO mess with set up to get this to display properly.
		
		
		
		//makes program appear
		this.setVisible(true);
	}

}
