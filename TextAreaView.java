import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


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
		
		textArea = new JTextArea(25, 50);
		textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
      
        focus = true;
        
        createFocusListener();
        createNewDocListener();
        resetLastCharIn();
	}
	
	public void resetLastCharIn(){
		lastCharIn = "";
		prevCharPos = 0;
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
				mainView.getInputHandler().getMediator().fileHandler.updateFileBuffer(textArea.getText());
			}
		});
	}
	
	/**
	 * Creates a new Document Listener
	 * When an event is fired, updateLog(Event e) is called
	 */
	public void createNewDocListener(){
		 textArea.getDocument().addDocumentListener(new DocumentListener() {
	        	public void changedUpdate(DocumentEvent e){
	        		//will never be fired in a JTextArea
	        		System.out.println("changed");
	        	}
	        	
	        	public void removeUpdate(DocumentEvent e){
	        		updateLog(e);
	        	}
	        	
	        	public void insertUpdate(DocumentEvent e){
	        		updateLog(e);
	        	}
	        });
	}
	
	/**
	 * Removes the Document Listener associated with the text area
	 */
	public void removeDocListener(){
		textArea.getDocument().removeDocumentListener(null);
	}
	
	//I dont think we need this, it isnt being used
	/**
	 * Gets the last character entered in the text area
	 * and if it is the ENTER key, updates the current file's buffer
	 * @param e
	 */
	private void updateLog(DocumentEvent e){
		Document doc = (Document)e.getDocument();
		try {
			// although the display is updated every key press, the file buffer is not
			// this will only update the buffer when the Enter key is pressed
			prevCharPos = doc.getLength() - 1;
			if(prevCharPos < 0) prevCharPos = 0;
			
			lastCharIn = doc.getText(prevCharPos, 1);
			
			if(lastCharIn.equals("\n")){	
				// to be implemented
				//mainView.getInputHandler().getMediator().updateFileBuffer(doc.getText(0, doc.getLength()));
			}
		} 
		
		catch (BadLocationException e1) {
			e1.printStackTrace();
		}
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
