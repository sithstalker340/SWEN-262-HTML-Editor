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
           
    BufferedImage img;
    
    public ImagePreviewer(String path){
       try{
           img = ImageIO.read(new File(path));
       }catch (IOException e){
    	   e.printStackTrace();
       }
       ImageIcon imageIcon = new ImageIcon(img);
       JLabel jLabel = new JLabel();
       jLabel.setIcon(imageIcon);
       this.getContentPane().add(jLabel, BorderLayout.CENTER);
       this.setName("Image Preview");
       this.pack();
       this.setLocationRelativeTo(null);
       this.setVisible(true);
      
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
}