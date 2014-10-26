import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//Methods to display and run dropdown menu functions (save, load, button commands)
public class MenuView extends JMenuBar
{
	JMenu file;
	JMenuItem newdoc;
	JMenuItem open;
	JMenuItem save;
	JMenuItem saveAs;
	JMenuItem Exit;
	
	JMenu edit;
	JMenuItem undo;
	JMenuItem redo;
	JMenuItem cut;
	JMenuItem copy;
	JMenuItem paste;
	JMenuItem delete;
	JMenuItem selectAll;
	//JMenuItem find_replace;???
	
	JMenu helpMenu;
	JMenuItem help;
	
	public MenuView(MainView mainView){}
	
	/**
	 * @param args
	 */
	public void init(MainView parent, ViewListener listener) 
	{
		//sets size of menu bar
		this.setSize(parent.getWidth(), 25);
		
		//START FILE MENU
		//Creates file menu
		file = new JMenu();
		//Creates "New" menu Item
		newdoc = new JMenuItem("New");
		//add actionListener for new
		newdoc.addActionListener(listener);
		//Creates "Open File" menu Item
		open = new JMenuItem("Open File...");
		//add actionListener for open
		open.addActionListener(listener);
		//Creates "Save" menu Item
		save = new JMenuItem("Save");
		//add actionListener for save
		save.addActionListener(listener);
		//Creates "Save As" menu Item
		saveAs = new JMenuItem("Save As...");
		//add actionListener for saveAs
		saveAs.addActionListener(listener);
		//Creates "Exit" menu Item
		Exit = new JMenuItem("Exit");
		//add actionListener for Exit
		Exit.addActionListener(listener);
		//Set Text of file menu
		file.setText("File");
		//add menu items for file
		file.add(newdoc);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		file.add(Exit);
		//add file menu to the menu bar
		this.add(file);
		//END FILE MENU
		
		//START EDIT MENU
		//Create edit menu
		edit = new JMenu();
		//Creates "Undo" menu Item
		undo = new JMenuItem("Undo");
		//add actionListener for undo
		undo.addActionListener(listener);
		//Creates "Redo" menu Item
		redo = new JMenuItem("Redo");
		//add actionListener for redo
		redo.addActionListener(listener);
		//Creates "Cut" menu Item
		cut = new JMenuItem("Cut");
		//add actionListener for cut
		cut.addActionListener(listener);
		//Creates "Copy" menu Item
		copy = new JMenuItem("Copy");
		//add actionListener for undo
		copy.addActionListener(listener);
		//Creates "Paste" menu Item
		paste = new JMenuItem("Paste");
		//add actionListener for paste
		paste.addActionListener(listener);
		//Creates "Delete" menu Item
		delete = new JMenuItem("Delete");
		//add actionListener for delete
		delete.addActionListener(listener);
		//Creates "Select All" menu Item
		selectAll = new JMenuItem("Select All");
		//add actionListener for selectAll
		selectAll.addActionListener(listener);
		//Set Text of edit menu
		edit.setText("Edit");
		//add menu items for edit
		edit.add(undo);
		edit.add(redo);
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(delete);
		edit.add(selectAll);
		//add edit menu to the menu bar
		this.add(edit);
		//END EDIT MENU
		
		//START HELP MENU
		//Create help menu
		helpMenu = new JMenu();
		//Create "Help" help menu item
		help = new JMenuItem("Help");
		//add actionListener for help
		help.addActionListener(listener);
		//Set text of help menu
		helpMenu.setText("Help");
		//add menu items for help
		helpMenu.add(help);
		//add help menu to the menu bar
		this.add(helpMenu);
		//END HELP MENU
		
		//make the menu bar visible
		this.setVisible(true);
	}

	
	

}
