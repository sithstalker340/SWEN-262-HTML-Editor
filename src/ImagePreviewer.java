import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ImagePreviewer extends Component {
           
    BufferedImage img;
 
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
 
    public ImagePreviewer(String path){
       try {
           img = ImageIO.read(new File(path));
       }catch (IOException e){
    	   e.printStackTrace();
       }
       
       JFrame f = new JFrame("Load Image Sample");
 
       f.add(this);
       f.pack();
       f.setVisible(true);
    }
}