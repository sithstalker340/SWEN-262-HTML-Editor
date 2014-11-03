import java.awt.CardLayout;
import javax.swing.JPanel;

//Methods to display tab hierarchy and switch tabs
public class MyCardLayout extends JPanel
{
	CardLayout cL;
	ViewListener vL;
	MainView mV;
	int i;
	/**
	 * @param args
	 */
	public MyCardLayout(ViewListener vL, MainView mV)
	{
		this.vL = vL;
		this.mV = mV;
		cL = new CardLayout();
		cL.setHgap(15);
		cL.setVgap(15);
		this.setLayout(cL);
		i = 1;
	}
	
	//to be called when you open a new file.
	public void addCard(String name, File file)
	{
		Card newCard = new Card(vL, name, file, mV, i);
		cL.addLayoutComponent(newCard, name);
		cL.show(this, name);
		//this.setLayout(cL);
		//System.out.println(cL.toString());
		i += 1;
	}

	//to be called to change from one tab to another
	public void show(String str) 
	{
		cL.show(this, str);
		
	}
	
}
