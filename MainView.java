import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainView extends JFrame
{
	InputHandler input;
	
	MenuView menu;
	ViewListener listener;
	BtnView buttons;
	TextAreaView textView;
	MyCardLayout cL;
	JPanel panel;
	JScrollPane scrollPane;
	
	public MainView(InputHandler i)
	{	
		input = i;
		input.getMediator().setMainView(this);
		input.setMainView(this);
		
		this.setTitle("Editor");
		this.setSize(700, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		listener = new ViewListener(input);
		listener.input.getMediator().setMainView(this);
		
		menu = new MenuView(this, listener); // menuBar object
		buttons = new BtnView(this, listener);	// all of the buttons
		cL = new MyCardLayout(listener, this);
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
        cL.addCard("Test1", null);
        cL.addCard("Test2", null);
        //cL.show("Test1");
        //panel.add(cL, BorderLayout.CENTER);
        //((MyCardLayout)panel.getComponent(2)).show("Test");
        
        this.setMinimumSize(new Dimension(300,300));
		this.pack();
		this.setLocationByPlatform(true);
		this.setVisible(true);	
	}
	
	public InputHandler getInputHandler()
	{
		return input;
	}
}
