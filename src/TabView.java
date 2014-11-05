import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
				mainView.input.changeCurrentFile(tabPane.getSelectedIndex());
			}
		});
	}
	
	public void createNewTab(String name, int index){
		JPanel innerPane = new JPanel();
		
		TextAreaView textView = new TextAreaView(mainView, listener);

		JScrollPane scrollPane = new JScrollPane(textView.getTextArea());
		scrollPane.setName("scrollPane");
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
	    
	    innerPane.setName(Integer.toString(index));
		innerPane.add(scrollPane);
		innerPane.setLayout(new GridLayout(1,2));		
	
		tabPane.addTab(name, innerPane);
		tabPane.setSelectedIndex(tabPane.getTabCount()-1);
		
		Image img = null;
		//get icon
		try {
		    img = ImageIO.read(getClass().getResource("resources/closeIcon.png"));
		} catch (IOException ex) {}
		
		//set title with close button
		tabPane.setTabComponentAt(
				tabPane.getTabCount()-1, 
				getTitlePanel(tabPane, innerPane, name, index, img, mainView.getInputHandler())
		);
	}
	
	private static JPanel getTitlePanel(final JTabbedPane tabbedPane, final JPanel panel, String title, final int id, Image img, final InputHandler input){
		JPanel titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		JLabel titleLbl = new JLabel(title);
		titleLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		titlePanel.add(titleLbl);
		JButton closeButton = new JButton();
		closeButton.setOpaque(true);
		int size = 14;
		
		if(img != null){
			closeButton.setIcon(new ImageIcon(img));
		}else{
			closeButton.setText("x");
		}
		
		closeButton.setPreferredSize(new Dimension(size, size));
		
		closeButton.addActionListener( new ActionListener(){
			@Override	
			public void actionPerformed(ActionEvent e) {
				if(input.closeTab(id))	
					tabbedPane.remove(panel);
			}
	  	});
	  
	  titlePanel.add(closeButton);

	  return titlePanel;
	 }
	
	
	public JTabbedPane getTabPane(){
		return tabPane;
	}

	public JTextArea getCurrentTextArea(){
		int index = tabPane.getSelectedIndex();
		JPanel tab = (JPanel)tabPane.getComponentAt(index);
		JScrollPane scrollPane = (JScrollPane)tab.getComponent(0);
		JViewport viewport = (JViewport)scrollPane.getComponent(0);
		JTextArea textArea = (JTextArea)viewport.getComponent(0);
		return textArea;
	}
	
	public void setCurrentText(String text){
		JTextArea textArea = getCurrentTextArea();
		textArea.setText(text);
	}
	
	public int getCursorStart(){
		return getCurrentTextArea().getCaret().getDot();
	}
	
	public int getCursorEnd(){
		return getCurrentTextArea().getCaret().getMark();
	}
}