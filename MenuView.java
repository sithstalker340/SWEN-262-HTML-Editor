import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//Methods to display and run dropdown menu functions (save, load, button commands)
@SuppressWarnings("serial")
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
	JMenuItem delete;
	JMenuItem wordWrap;
	JMenuItem autoIndent;
	JMenuItem indent;
	
	
	public MenuView(MainView parent, ViewListener listener){
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
		//Creates "Delete" menu Item
		delete = new JMenuItem("Delete");
		//add actionListener for delete
		delete.addActionListener(listener);
		//Creates "Word Wrap" menu Item
		wordWrap = new JMenuItem("Word Wrap");
		//add actionListener for wordWrap
		wordWrap.addActionListener(listener);
		//Creates "autoIndent" menu Item
		autoIndent = new JMenuItem("Auto-Indent");
		//add actionListener for autoIndent
		autoIndent.addActionListener(listener);
		//Creates "Indent" menu Item
		indent = new JMenuItem("Indent");
		//add actionListener for indent
		indent.addActionListener(listener);
		//Set Text of edit menu
		edit.setText("Edit");
		//add menu items for edit
		edit.add(undo);
		edit.add(redo);
		edit.add(delete);
		edit.add(wordWrap);
		edit.add(autoIndent);
		edit.add(indent);
		//add edit menu to the menu bar
		this.add(edit);
		//END EDIT MENU

		//make the menu bar visible
		this.setVisible(true);
	}
}
