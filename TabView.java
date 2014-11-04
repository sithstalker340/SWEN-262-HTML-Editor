
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class TabView extends JPanel{
	
	MainView mainView;
	ViewListener listener;

	JTabbedPane tabPane;
	
	public TabView(MainView parent, ViewListener vListener){
		mainView = parent;
		listener = vListener;
		
		tabPane = new JTabbedPane();
		
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if( tabPane.getTabCount() < 1 ){return;}
				
				int index = tabPane.getSelectedIndex();
				JPanel tab = (JPanel)tabPane.getComponentAt(index);
				JScrollPane scrollPane = (JScrollPane)tab.getComponent(0);
				JViewport viewport = (JViewport)scrollPane.getComponent(0);
				JTextArea textArea = (JTextArea)viewport.getComponent(0);
				String buffer = textArea.getText();
				
				textArea.setText("DOES THIS FUCKING WORK?");
				
				JPanel tab1 = (JPanel)tabPane.getComponentAt(index);
				JScrollPane scrollPane1 = (JScrollPane)tab1.getComponent(0);
				JViewport viewport1 = (JViewport)scrollPane1.getComponent(0);
				JTextArea textArea1 = (JTextArea)viewport1.getComponent(0);
				String buffer1 = textArea1.getText();
				

				System.out.println(buffer1);
			}
		});
				
		
	}
	
	public void createNewTab(String name, int index){
		JPanel innerPane = new JPanel();
		
		TextAreaView textView = new TextAreaView(mainView, listener);
		textView.setName(Integer.toString(index));
		
		//textAreaList.add(textView);
		//setCurrentTextView(index);
		
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
		return tabPane;
	}
	
}