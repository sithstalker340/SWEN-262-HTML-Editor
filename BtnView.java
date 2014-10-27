import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

//Methods to display buttons and run attached functions (inserts, HTML constructs)
public class BtnView extends JPanel
{
	JButton btnA;//<a>
	JButton btnB;//<b>   (bold)
	JButton btnI;//<i>   (italics)
	//JButton btnBr;//<br>
	JButton btnHeader;//<header>
	//JButton btnLi;//<li>   (list item)
	JButton btnOl;//<ol>   (ordered list)
	JButton btnUl;//<ul>   (unordered list)
	JButton btnDl;//<dl>   (dictionary list)
	JButton btnTable;//<Table>
	JButton btnImg;//<img>   (Image)
	
	public BtnView(){}
	
	public void init(MainView parent, ViewListener listener) 
	{
		this.setSize(parent.getWidth(), 25);
		this.setLayout(new FlowLayout());
		this.add(btnB = new JButton("<b>"));
		this.add(btnI = new JButton("<i>"));
		this.add(btnA = new JButton("<a>"));
		this.add(btnHeader = new JButton("<Header>"));
		this.add(btnOl = new JButton("<ol>"));
		this.add(btnUl = new JButton("<ul>"));
		this.add(btnDl = new JButton("<dl>"));
		this.add(btnTable = new JButton("<table>"));
		this.add(btnImg = new JButton("<img>"));
		
		this.setVisible(true);
	}
	
}
