import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class TabView extends JPanel{
	
	MainView mainView;
	ViewListener listener;
	
	List<TextAreaView> textAreaList;
	JTabbedPane tabPane;
	
	public TabView(MainView parent, ViewListener vListener){
		mainView = parent;
		listener = vListener;
		
		textAreaList = new ArrayList<TextAreaView>();
		
		tabPane = new JTabbedPane();
		
		tabPane.addTab("Tab 1", createNewTab("", 0));
	}
	
	private JPanel createNewTab(String loc, int index){
		JPanel innerPane = new JPanel();
		
		TextAreaView textView = new TextAreaView(mainView, listener);
		textView.setName(Integer.toString(index));
		textAreaList.add(textView);
		
		JScrollPane scrollPane = new JScrollPane(textView.getTextArea());
		scrollPane.setName("scrollPane");
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
		scrollPane.setSize(new Dimension(500, 400));
	    
	    innerPane.setName(Integer.toString(index));
		innerPane.add(scrollPane);
		innerPane.setLayout(new GridLayout(1,1));
		return innerPane;
	}
	
	public JTabbedPane getTabPane(){
		if(tabPane == null){
			System.out.println("tab pane is null");
		}
		return tabPane;
	}
	
	public TextAreaView getTextView(){
		 int index = Integer.parseInt(tabPane.getComponentAt(tabPane.getSelectedIndex()).getName());
		 if(textAreaList.get(index) == null){
				System.out.println("textAreaView is null");
			}
		 System.out.println("im being called");
		 return textAreaList.get(index);
	}
}