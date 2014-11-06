import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


	/**
	 * This class demonstrates how to load an Image from an external file
	 */
	public class ImagePreviewer extends Component {
	           
	    BufferedImage img;
	 
	    public void paint(Graphics g) {
	        g.drawImage(img, 0, 0, null);
	    }
	 
	    public ImagePreviewer(String path){
	       try {
	           img = ImageIO.read(new File(path));
	       } catch (IOException e) {
	       }
	       
	       JFrame f = new JFrame("Load Image Sample");
           
	 
	        f.add(this);
	        f.pack();
	        f.setVisible(true);
	 
	    }
	 
	    public Dimension getPreferredSize() {
	        if (img == null) {
	             return new Dimension(100,100);
	        } else {
	           return new Dimension(img.getWidth(null), img.getHeight(null));
	       }
	    }
	}
