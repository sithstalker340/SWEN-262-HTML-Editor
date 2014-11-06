import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePreviewer extends JFrame{
           
    BufferedImage image;
    String path;
    JComboBox<String> comboBox;
    JPanel buttonPanel;
    JLabel label;
    
    public ImagePreviewer(String buffer){
    	
    	path = "";
    	getImagePath(buffer);
    }
    
    public String getImagePath(String buffer){
    	this.setMinimumSize(new Dimension(300, 100));
    	
    	JPanel panel = new JPanel();
    	panel.setLayout(new BorderLayout());
    	
    	label = new JLabel("Select the image to preview: ");
    	
    	List<String> imgList = parse(buffer);

    	comboBox = new JComboBox<String>();
   
    	for(int i = 0; i < imgList.size(); i++){
    		comboBox.addItem(imgList.get(i));
    	}
    
    	buttonPanel = new JPanel();
    	buttonPanel.setLayout(new GridLayout(1,2));
    	
    	JButton yesButton = new JButton("Ok");
    	JButton noButton = new JButton("Cancel");
    	
    	yesButton.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e){
        		path = comboBox.getSelectedItem().toString();
        		System.out.println(path);
        		try{
        			displayImage(path);
        		}
        		
        		catch(Exception ex){
        			ex.printStackTrace();
        		}
        		
        		preview();
        	}
        });
    	
    	noButton.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e){
        		endPreviewer();
        	}
        });
    	
    	buttonPanel.add(yesButton);
    	buttonPanel.add(noButton);
    	
    	label.setVisible(true);
    	comboBox.setVisible(true);
    	buttonPanel.setVisible(true);
    	
    	panel.add(label, BorderLayout.NORTH);
    	panel.add(comboBox, BorderLayout.CENTER);
    	panel.add(buttonPanel, BorderLayout.SOUTH);
    	
    	this.add(panel);
    	
    	this.pack();
    	this.setContentPane(panel);
    	this.setLocationRelativeTo(null);
    	this.setVisible(true);
    	
    	return path;
    }
    
    public void preview()
    {
    	label.setVisible(false);
    	buttonPanel.setVisible(false);
    	comboBox.setVisible(false);
    }
    
    public void displayImage(String path){
    	 try{
    		 String tempPath = "";
    		 tempPath = path.replaceAll("\\\\", "\\\\\\\\");
    		 tempPath = tempPath.replaceAll("\"", "");
    		 image = null;
    	     
    		 System.out.println(new File(tempPath).exists());
    		 System.out.println(tempPath);
    		 
    		 image = ImageIO.read(new File(tempPath));
    	        
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
    	 
    	 catch (Exception e){
      	   e.printStackTrace();
         }
    }
    
    public List<String> parse(String buffer){
		List<String> imgList = new ArrayList<String>();
		String[] splitText;
		
		splitText = buffer.split("[\n]+");
		String[] tempList;
		
		for(int i = 0; i < splitText.length; i++){
			tempList = splitText[i].split("<img src=+");
			
			for(int j = 0; j < tempList.length; j++){
				if(tempList[j].startsWith("\"")){
					imgList.add(tempList[j]);
				}
			}
		}
		
		int end;
		for(int i = 0; i < imgList.size(); i++){
			end = imgList.get(i).indexOf(">");
			if(end > 0){
				imgList.set(i, imgList.get(i).substring(0,end));
			}
		}
		
		return imgList;
	}
    
    private void endPreviewer(){
    	this.dispose();
    }
}