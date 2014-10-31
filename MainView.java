import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainView extends JFrame
{
	MenuView menu;
	ViewListener listener;
	BtnView buttons;
	CardLayout cL;
	JPanel panel;
	JTextArea textArea;
	JScrollPane scrollPane;
	
	public MainView(Mediator m)
	{	
		//this.setLayout(new GridBagLayout()); 
		this.setTitle("Editor");
		this.setSize(700, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		listener = new ViewListener();
		listener.setMediator(m);
		
		menu = new MenuView(this, listener); // menuBar object
		buttons = new BtnView(this, listener);	// all of the buttons
			
		// make a new panel, give it a border with padding, select the Border layout
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0,15,15,15));
		panel.setLayout(new BorderLayout(0,0));
		this.setContentPane(panel);
		
		// create a new text box, set options
		textArea = new JTextArea(25, 50);
		textArea.setWrapStyleWord(true);
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        
        // create a new scrollable window, add the text box to it
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        // add each item to the content panel 
        this.setJMenuBar(menu);
        panel.add(buttons, BorderLayout.NORTH);    
        panel.add(scrollPane, BorderLayout.CENTER);
        
        this.setMinimumSize(new Dimension(300,300));
		this.pack();
		this.setLocationByPlatform(true);
		this.setVisible(true);		
	}
}
