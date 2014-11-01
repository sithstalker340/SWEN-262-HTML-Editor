import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainView extends JFrame
{
	MenuView menu;
	ViewListener listener;
	BtnView buttons;
	TextAreaView textView;
	CardLayout cL;
	JPanel panel;
	JScrollPane scrollPane;
	
	public MainView(Mediator m)
	{	
		m.setMainView(this);
		
		//this.setLayout(new GridBagLayout()); 
		this.setTitle("Editor");
		this.setSize(700, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		listener = new ViewListener();
		listener.setMediator(m);
		listener.mediator.setMainView(this);
		
		menu = new MenuView(this, listener); // menuBar object
		buttons = new BtnView(this, listener);	// all of the buttons
		textView = new TextAreaView(this, listener); // the text box object
			
		// make a new panel, give it a border with padding, select the Border layout
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0,15,15,15));
		panel.setLayout(new BorderLayout(0,0));
		this.setContentPane(panel);

        // create a new scrollable window, add the text box to it
        scrollPane = new JScrollPane(textView.getTextArea());
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
