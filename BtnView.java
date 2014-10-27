import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

//Methods to display buttons and run attached functions (inserts, HTML constructs)
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
	
	public BtnView(){}
	
	public void init(MainView parent, ViewListener listener) 
	{
		vListener = listener;
		this.setSize(parent.getWidth(), 25);
		this.setLayout(new FlowLayout());
		this.add(btnB = new JButton("<b>"));
		//add actionListener for btnB
		btnB.addActionListener(vListener);
		this.add(btnI = new JButton("<i>"));
		//add actionListener for btnI
		btnI.addActionListener(vListener);
		this.add(btnA = new JButton("<a>"));
		//add actionListener for btnA
		btnA.addActionListener(vListener);
		this.add(btnHeader = new JButton("<Header>"));
		//add actionListener for btnHeader
		btnHeader.addActionListener(vListener);
		this.add(btnOl = new JButton("<ol>"));
		//add actionListener for btnOl
		btnOl.addActionListener(vListener);
		this.add(btnUl = new JButton("<ul>"));
		//add actionListener for btnUl
		btnUl.addActionListener(vListener);
		this.add(btnDl = new JButton("<dl>"));
		//add actionListener for btnDl
		btnDl.addActionListener(vListener);
		this.add(btnTable = new JButton("<table>"));
		//add actionListener for btnTable
		btnTable.addActionListener(vListener);
		this.add(btnImg = new JButton("<img>"));
		//add actionListener for btnImg
		btnImg.addActionListener(vListener);
		
		this.setVisible(true);
	}
	
}
