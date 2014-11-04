import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class LinkedView extends JFrame {
	public LinkedView(){

		this.setMinimumSize(new Dimension(300,450));
		this.setTitle("Linked View");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
