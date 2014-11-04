import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainView extends JFrame
{
	InputHandler input;
	
	MenuView menu;
	ViewListener listener;
	BtnView buttons;
	MyCardLayout cL;
	JPanel panel;
	TabView tabView;
	
	public MainView(InputHandler i)
	{	
		input = i;
		
		this.setTitle("Editor");
		this.setSize(700, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		listener = new ViewListener(input);
		
		menu = new MenuView(this, listener); // menuBar object
		buttons = new BtnView(this, listener);	// all of the buttons
		cL = new MyCardLayout(listener, this);
		//textView = new TextAreaView(this, listener); // the text box object
			
		// make a new panel, give it a border with padding, select the Border layout
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0,15,15,15));
		panel.setLayout(new BorderLayout(0,0));
		this.setContentPane(panel);

		tabView = new TabView(this, listener);
		
		panel.add(tabView.getTabPane());
		   
        // add each item to the content panel 
        this.setJMenuBar(menu);
        panel.add(buttons, BorderLayout.NORTH);    
        //panel.add(scrollPane, BorderLayout.CENTER);
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
	
	public TextAreaView getCurrentTextView(){
		if(tabView.getTextView() == null){
			System.out.println("null text view");
		}
		
		return tabView.getTextView();
	}
	
	public void addTab(String name, int id){
		tabView.createNewTab(name, id);
	}
}
