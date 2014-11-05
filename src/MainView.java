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
	JPanel panel;
	TabView tabView;
	LinkedView linkedView;
	
	public MainView(InputHandler i)
	{	
		input = i;
		
		this.setMinimumSize(new Dimension(650,450));
		this.setTitle("Editor");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		listener = new ViewListener(input);
		
		menu = new MenuView(this, listener); // menuBar object
		buttons = new BtnView(this, listener);	// all of the buttons
			
		// make a new panel, give it a border with padding, select the Border layout
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0,15,15,15));
		panel.setLayout(new BorderLayout(0,0));
		this.setContentPane(panel);

		tabView = new TabView(this, listener);
		tabView.setSize(new Dimension(800,400));
		
		panel.add(tabView.getTabPane());
		   
        // add each item to the content panel 
        this.setJMenuBar(menu);
        panel.add(buttons, BorderLayout.NORTH);    
        
        //this.setMinimumSize(new Dimension(300,300));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
	}
	
	public void quit(){
		if( tabView.closeAll() ){
			//close program
		}		
	}
	
	public InputHandler getInputHandler()
	{
		return input;
	}
	
	public void addTab(String name, int id){
		tabView.createNewTab(name, id);
	}
	
	public String getText(){
		return tabView.getText();
	}
	
	public void setText(String text){
		tabView.setText(text);
	}
	
	public int getCursorStart(){
		return tabView.getCursorStart();
	}
	
	public int getCursorEnd(){
		return tabView.getCursorEnd();
	}
	
	public void setIsSaved(boolean b){
		input.setIsSaved(b);
	}
	
	public void newLinkedView(int strategy ){
		if(strategy == 1){
			linkedView = new LinkedView(new SortByAppear(), getText());
		}
		else{
			linkedView = new LinkedView(new SortByAlpha(), getText());
		}
	}
}
