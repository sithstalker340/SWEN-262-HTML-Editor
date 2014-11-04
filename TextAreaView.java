import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class TextAreaView extends JTextArea{
	
	ViewListener vListener;
	MainView mainView;
	
	JTextArea textArea;
	String lastCharIn;
	int prevCharPos;
	boolean focus;
	
	public TextAreaView(MainView parent, ViewListener listener){
		vListener = listener;
		mainView = parent;
		
		textArea = new JTextArea(50, 50);
		textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
      
        focus = true;
        
        createFocusListener();
	}
	
	/**
	 * Creates a listener for the focus of the text box.
	 * Any time the box loses focus, its text is saved to the file it belongs to
	 */
	public void createFocusListener(){
		textArea.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e){
				focus = true;
			}
			
			public void focusLost(FocusEvent e){
				focus = false;
				//mainView.getInputHandler().menuViewInput("Save"); // this is saving the file every time it loses focus...
				mainView.getInputHandler().updateFileBuffer();
			}
		});
	}
	
	public void createDocumentListener(){
		textArea.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				mainView.setIsSaved(false);
		    }
		    public void removeUpdate(DocumentEvent e) {
		    	mainView.setIsSaved(false);
		    }
		    public void changedUpdate(DocumentEvent e) {
		        //Plain text components do not fire these events
		    }
		});
	}
			
	/**
	 * Returns the text area 
	 * @return
	 */
	public JTextArea getTextArea(){
		return textArea;
	}
	
	public int getCursorStart(){
		return textArea.getCaret().getDot();
	}
	
	public int getCursorEnd(){
		return textArea.getCaret().getMark();
	}
}
