import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class TabView extends JPanel{
	
	MainView mainView;
	ViewListener listener;
	
	List<TextAreaView> textAreaList;
	TextAreaView currentTextArea;
	JTabbedPane tabPane;
	
	public TabView(MainView parent, ViewListener vListener){
		mainView = parent;
		listener = vListener;
		
		textAreaList = new ArrayList<TextAreaView>();
		tabPane = new JTabbedPane();
		
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//System.out.println("Tab: " + tabPane.getSelectedIndex());
				
				//System.out.println("name: " + textAreaList.get(i).getName());
				//System.out.println("current tab: " + tabPane.getSelectedComponent().getName());
				
				int idName = Integer.parseInt(tabPane.getSelectedComponent().getName());
				for(int i = 0; i < textAreaList.size(); i++){
					if(idName == i){
						//mainView.getInputHandler().changeCurrentFile(idName);
						currentTextArea = textAreaList.get(idName);
						mainView.getInputHandler().changeCurrentFile(idName);
					}
				}
			}
		});
	}
	
	public void createNewTab(String name, int index){

		JPanel innerPane = new JPanel();
		
		TextAreaView textView = new TextAreaView(mainView, listener);
		textView.setName(Integer.toString(index));
		System.out.println(textView.getName());
		textAreaList.add(textView);
		setCurrentTextView(index);
		
		JScrollPane scrollPane = new JScrollPane(textView.getTextArea());
		scrollPane.setName("scrollPane");
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
		scrollPane.setSize(new Dimension(500, 400));
	    
	    innerPane.setName(Integer.toString(index));
		innerPane.add(scrollPane);
		innerPane.setLayout(new GridLayout(1,1));
		
		tabPane.addTab(name, innerPane);
	}
	
	public JTabbedPane getTabPane(){
		if(tabPane == null){
			System.out.println("tab pane is null");
		}
		return tabPane;
	}
	
	public void setCurrentTextView(int id){
		currentTextArea = textAreaList.get(id);
	}
	
	public TextAreaView getTextView(){
		return currentTextArea;
	}	
}