import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

//Methods to display and run dropdown menu functions (save, load, button commands)
@SuppressWarnings("serial")
public class MenuView extends JMenuBar
{
	JMenu file;
	JMenuItem newDoc;
	JMenuItem open;
	JMenuItem save;
	JMenuItem saveAs;
	JMenuItem exit;
	
	JMenu edit;
	JMenuItem undo;
	JMenuItem redo;
	JMenuItem delete;
	JMenuItem wordWrap;
	JMenuItem autoIndent;
	JMenuItem indent;
	
	
	public MenuView(final MainView parent, ViewListener listener){
		this.setSize(parent.getWidth(), 25);

		Action actionNew = new AbstractAction("new") {
			public void actionPerformed(ActionEvent e){}
		};
		Action actionOpen = new AbstractAction("Open File...") {
			public void actionPerformed(ActionEvent e){}
		};
		Action actionSave = new AbstractAction("Save") {
			public void actionPerformed(ActionEvent e){}
		};
		Action actionSaveAs = new AbstractAction("Save As...") {
			public void actionPerformed(ActionEvent e){}
		};
		Action actionExit = new AbstractAction("Exit") {
			public void actionPerformed(ActionEvent e){}
		};
		
		actionNew.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control N"));
		actionOpen.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control O"));
		actionSave.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control S"));
		actionSaveAs.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control E"));
		actionExit.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control Q"));
		
		file = new JMenu();
		
		newDoc = new JMenuItem(actionNew);
		newDoc.setText("New");
		newDoc.addActionListener(listener);
		
		open = new JMenuItem(actionOpen);
		open.setText("Open File...");
		open.addActionListener(listener);

		save = new JMenuItem(actionSave);
		save.setText("Save");
		save.addActionListener(listener);

		saveAs = new JMenuItem(actionSaveAs);
		saveAs.setText("Save As...");
		saveAs.addActionListener(listener);

		exit = new JMenuItem(actionExit);
		exit.setText("Exit");
		exit.addActionListener(listener);	
		
		file.setText("File");

		file.add(newDoc);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		file.add(exit);

		this.add(file);

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
