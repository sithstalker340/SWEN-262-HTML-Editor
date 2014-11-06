import javax.swing.JTextArea;

/**
 * Class that deals with the text area front end.
 * @author Andrew
 *
 */
@SuppressWarnings("serial")
public class TextAreaView extends JTextArea{
	
	ViewListener vListener;
	MainView mainView;
	
	JTextArea textArea;
	String lastCharIn;
	int prevCharPos;
	
	/**
	 * The constructor of the TestAreaView.
	 * @param parent
	 * @param listener
	 */
	public TextAreaView(MainView parent, ViewListener listener){
		vListener = listener;
		mainView = parent;
		
		textArea = new JTextArea(50, 50);
		textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
	}
	
	/**
	 * Returns the text area 
	 * @return
	 */
	public JTextArea getTextArea(){
		return textArea;
	}
	
	/**
	 * Returns the cursor start position.
	 * @return
	 */
	public int getCursorStart(){
		return textArea.getCaret().getDot();
	}
	
	/**
	 * Returns the cursor end position.
	 * @return
	 */
	public int getCursorEnd(){
		return textArea.getCaret().getMark();
	}
}
