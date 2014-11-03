import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

//Methods to display and add changes to the text buffer
public class Card extends JPanel
{
	TextAreaView textView;
	ViewListener listener;
	MainView main;
	JScrollPane scrollPane;
	JPanel buttonPanel;
	JPanel panel;
	//gridBagLayout variables
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	GridBagConstraints c;
	
	Map<String, JButton> btn = new HashMap<String, JButton>();

	public Card(ViewListener l, String name, File file, MainView mV, int i)
	{
		listener = l;
		this.setLayout(new BorderLayout());
		textView = new TextAreaView(mV, l);
		
		// make a new panel, give it a border with padding, select the Border layout
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0,15,15,15));
		panel.setLayout(new BorderLayout(0,0));
		
		//btnCardPanel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.setPreferredSize(new Dimension(300, 40)); 
		buttonPanel.setMinimumSize(new Dimension(300, 40)); 
		buttonPanel.setMaximumSize(new Dimension(300, 40)); 
		
		c = new GridBagConstraints();
	
		if (shouldFill) 
		{
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		if (shouldWeightX) 
		{
			c.weightx = 0.5;
		}
	
		//ADDS BUTTONS
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		c.ipady = 10;
		c.weightx = 0.0;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		
	    btn.put("File " + i, new JButton("File " + i));
	    btn.get("File " + i).addActionListener(l); 
	
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = i-1;//-1 places it in first grid space
		buttonPanel.add(btn.get("File " + i), c);
		//System.out.println((btn.get("File " + i)).toString());
		
	    			
		// create a new scrollable window, add the text box to it
        scrollPane = new JScrollPane(textView.getTextArea());
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        buttonPanel.setVisible(true);
        scrollPane.setVisible(true);
        panel.add(buttonPanel, BorderLayout.NORTH);
        //panel.add(scrollPane, BorderLayout.CENTER);
        
        panel.setVisible(true);
        panel.setBackground(Color.BLUE);
		//System.out.println(panel.toString());
		//System.out.println(this.toString());
        this.add(panel, BorderLayout.CENTER);
        //this.validate();
        //this.repaint();
        this.setMinimumSize(new Dimension(300,300));
        this.setVisible(true);
	}

}
