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
	JMenuItem wordWrap;
	
	
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

		
		Action actionUndo = new AbstractAction("Undo") {
			public void actionPerformed(ActionEvent e){}
		};
		Action actionRedo = new AbstractAction("Redo") {
			public void actionPerformed(ActionEvent e){}
		};
		Action actionWordWrap = new AbstractAction("WordWrap") {
			public void actionPerformed(ActionEvent e){}
		};		
		
		actionUndo.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control Z"));
		actionRedo.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control Y"));
		actionWordWrap.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control W"));
		
		edit = new JMenu();

		undo = new JMenuItem(actionUndo);
		undo.setText("Undo");
		undo.addActionListener(listener);

		redo = new JMenuItem(actionRedo);
		redo.setText("Redo");
		redo.addActionListener(listener);

		wordWrap = new JMenuItem(actionWordWrap);
		wordWrap.setText("Word Wrap");
		wordWrap.addActionListener(listener);

		edit.setText("Edit");
		edit.add(undo);
		edit.add(redo);
		edit.add(wordWrap);

		this.add(edit);

		this.setVisible(true);
	}
}
