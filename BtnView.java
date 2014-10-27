import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

//Methods to display buttons and run attached functions (inserts, HTML constructs)
public class BtnView extends JPanel
{
	JButton btnA;//<a>
	JButton btnB;//<b>   (bold)
	JButton btnStrike;//<strike>   Not supported in HTML5
	JButton btnBr;//<br>
	JButton btnCenter;//<center>   Not supported in HTML5
	JButton btnFont;//<font>  Not supported in HTML5
	//JButton btnButton;???
	JButton btnDiv;//<div>
	JButton btnHeader;//<header>
	JButton btnFooter;//<footer>
	JButton btnHead;//<head>
	JButton btnBody;//<body>
	JButton btnH1;//<h1>
	JButton btnH2;//<h2>
	JButton btnH3;//<h3>
	JButton btnH4;//<h4>
	JButton btnH5;//<h5>
	JButton btnH6;//<h6>
	JButton btnHTML;//<HTML>
	JButton btnComment;//<!--...-->
	//JButton btnImg;???
	//JButton btnInput;???
	JButton btnLabel;//<label>
	JButton btnLi;//<li>   (list item)
	JButton btnOl;//<ol>   (ordered list)
	JButton btnUl;//<ui>   (unordered list)
	JButton btnP;//<P>   (paragraph)
	JButton btnQ;//<q>   (quote)
	JButton btnSpan;//<Span>
	JButton btnSub;//<Sub>  (Subscript)
	JButton btnSup;//<Sup>  (Superscript)
	JButton btnStyle;//<Style>
	JButton btnTable;//<Table>
	JButton btnTitle;//<Title>
	//UNDERLINE?????????CAN'T FIND TAG//
	
	public BtnView(){}
	
	public void init(MainView parent, ViewListener listener) 
	{
		this.setSize(parent.getWidth(), 25);
		this.setLayout(new FlowLayout());
		this.add(btnA = new JButton("<a>"));
		this.add(btnB = new JButton("<b>"));
		this.add(btnStrike = new JButton("<strike>"));
		this.add(btnBr = new JButton("<br>"));
		this.add(btnCenter = new JButton("<center>"));
		this.add(btnFont = new JButton("<font>"));
		/*JButton btnDiv;
		JButton btnHeader;
		JButton btnFooter;
		JButton btnHead;
		JButton btnBody;
		JButton btnH1;
		JButton btnH2;
		JButton btnH3;
		JButton btnH4;
		JButton btnH5;
		JButton btnH6;
		JButton btnHTML;
		JButton btnComment;
		JButton btnLabel;
		JButton btnLi;
		JButton btnOl;
		JButton btnUl;
		JButton btnP;
		JButton btnQ;
		JButton btnSpan;
		JButton btnSub;
		JButton btnSup;
		JButton btnStyle;
		JButton btnTable;
		JButton btnTitle;*/
		System.out.println(this.getLayout());
		this.setVisible(true);
	}
	
}
