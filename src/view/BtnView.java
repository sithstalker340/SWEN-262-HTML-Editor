package view;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Methods to display buttons and run attached functions (inserts, HTML constructs)
 * @author Dylan, Andrew
 *
 */
public class BtnView extends JPanel
{
	JButton btnA;//<a>
	JButton btnB;//<b>   (bold)
	JButton btnI;//<i>   (italics)
	JButton btnHeader;//<header>
	JButton btnOl;//<ol>   (ordered list)
	JButton btnUl;//<ul>   (unordered list)
	JButton btnDl;//<dl>   (dictionary list)
	JButton btnTable;//<Table>
	JButton btnImg;//<img>   (Image)
	
	ViewListener vListener;
	
	/**
	 * Creates and connects all of the buttons to the listeners.
	 * @param parent
	 * @param listener
	 */
	public BtnView(MainView parent, ViewListener listener){
	
		vListener = listener;
		
		this.setSize(parent.getWidth(), 25);
		this.setLayout(new FlowLayout());
		
		this.add(btnB = new JButton("b"));
		btnB.setFocusable(false);
		btnB.addActionListener(vListener);
		
		this.add(btnI = new JButton("i"));
		btnI.addActionListener(vListener);
		btnI.setFocusable(false);
		
		this.add(btnA = new JButton("a"));
		btnA.addActionListener(vListener);
		btnA.setFocusable(false);
		
		this.add(btnHeader = new JButton("header"));
		btnHeader.addActionListener(vListener);
		btnHeader.setFocusable(false);
		
		this.add(btnOl = new JButton("ol"));
		btnOl.addActionListener(vListener);
		btnOl.setFocusable(false);
		
		this.add(btnUl = new JButton("ul"));
		btnUl.addActionListener(vListener);
		btnUl.setFocusable(false);
		
		this.add(btnDl = new JButton("dl"));
		btnDl.addActionListener(vListener);
		btnDl.setFocusable(false);
		
		this.add(btnTable = new JButton("table"));
		btnTable.addActionListener(vListener);
		btnTable.setFocusable(false);
		
		this.add(btnImg = new JButton("img"));
		btnImg.addActionListener(vListener);
		btnImg.setFocusable(false);
		
		this.setVisible(true);
	}
}