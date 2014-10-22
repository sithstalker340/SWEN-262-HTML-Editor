import javax.swing.JButton;
import javax.swing.JPanel;


public class MainView extends JPanel
{
	MenuView menu = new MenuView();
	BtnView buttons = new BtnView();
	CardLayout cL = new CardLayout();
	
	/**
	 * @param args
	 */
	public void init(MainFile parent) 
	{
		this.show();
		this.setBounds(0, 0, parent.getWidth(), parent.getHeight());
		//JButton x = new JButton();
		menu.init(this);
		this.add(x);
		menu.show();
		menu.setVisible(true);
	}

}
