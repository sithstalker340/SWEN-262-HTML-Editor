import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
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
       JLabel jLabel = new JLabel();
       this.setName("Image Preview");
       jLabel.setIcon(imageIcon);
       jLabel.setName("Image Preview");
       this.getContentPane().add(jLabel, BorderLayout.CENTER);
       
       this.pack();
       this.setLocationRelativeTo(null);
       this.setVisible(true);
      
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
}