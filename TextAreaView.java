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
	
	public TextAreaView(MainView parent, ViewListener listener){
		vListener = listener;
		mainView = parent;
		
		textArea = new JTextArea(25, 50);
		textArea.setWrapStyleWord(true);
        textArea.setEditable(true);
        textArea.setLineWrap(true);
       
        textArea.getDocument().addDocumentListener(new DocumentListener() {
        	public void changedUpdate(DocumentEvent e){
        		//will never be fired in a JTextArea
        	}
        	
        	public void removeUpdate(DocumentEvent e){
        		updateLog(e, "removed");
        	}
        	
        	public void insertUpdate(DocumentEvent e){
        		updateLog(e, "added");
        	}
        });
	}
	
	private void updateLog(DocumentEvent e, String action){
		Document doc = (Document)e.getDocument();
		try {
			// although the display is updated every key press, the file buffer is not
			// this will only update the buffer when a backSpace or the Enter key is pressed
			String s = doc.getText(doc.getLength()-1, 1);
			if(s.equals("\n")){
				// to be implemented
			}
		} 
		
		catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}
		
	public JTextArea getTextArea(){
		return textArea;
	}
}
