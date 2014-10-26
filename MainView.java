import javax.swing.JButton;
import javax.swing.JPanel;


public class MainView extends JPanel
{
	MenuView menu = new MenuView();
	BtnView buttons = new BtnView();
	CardLayout cL = new CardLayout();
	
	public MainView(MainFile parent)
	{
		this.init(parent);
	}
	
	/**
	 * @param args
	 */
	public void init(MainFile parent) 
	{
		//this.setBounds(0, 0, , height)
		this.setVisible(true);
		this.setBounds(0, 0, parent.getWidth(), parent.getHeight());
		//JButton x = new JButton();
		menu.init(this);
		this.add(menu);
		//x.setVisible(true);
		menu.setVisible(true);
	}

}
