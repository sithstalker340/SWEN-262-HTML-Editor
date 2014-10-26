import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//Methods to display and run dropdown menu functions (save, load, button commands)
public class MenuView extends JMenuBar
{
	public MenuView(MainFile parent){}
	
	/**
	 * @param args
	 */
	public void init(MainFile parent, ViewListener listener) 
	{
		this.setSize(parent.getWidth(), 25);
		JMenu file = new JMenu();
		JMenuItem newdoc = new JMenuItem("New");
		JMenuItem open = new JMenuItem("Open File...");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem saveAs = new JMenuItem("Save As...");
		JMenuItem Exit = new JMenuItem("Exit");
		file.setText("File");
		file.add(newdoc);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		file.add(Exit);
		//Exit.addActionListener(listener);
		this.add(file);
		this.setVisible(true);
	}

	
	

}
