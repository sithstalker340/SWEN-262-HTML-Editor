import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ImagePreviewer extends JFrame{
           
    BufferedImage image;
    
    public ImagePreviewer(String path){
       try{
           image = ImageIO.read(new File(path));
       }catch (IOException e){
    	   e.printStackTrace();
       }
       
       ImageIcon imageIcon = new ImageIcon(image);
       JLabel label = new JLabel();
       this.setName("Image Preview");
       label.setIcon(imageIcon);
       this.getContentPane().add(label, BorderLayout.CENTER);
       
       this.pack();
       this.setLocationRelativeTo(null);
       this.setVisible(true);
      
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
}