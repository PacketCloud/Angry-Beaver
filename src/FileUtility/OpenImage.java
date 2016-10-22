package FileUtility;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.*;
import javax.swing.*;

/*
 * 	OpenImage contains a map of all Image Keys to their Directories.
 * 		It will return an Image when given a key. 
 */
public class OpenImage {
	private Map<String, String> imageMap = new HashMap<String, String>();
	
	public static void main(String[] args) throws IOException
	  {
		OpenImage("Resources/Textures/Background/ExampleBackground.png");
	  }
	
	public OpenImage() {
		//TODO: Initialize Key to Directory mapping for all images
		//Example: getImageMap().put("Beaver", "/Resources/Sprites/Player/Beaver_Walking.gif");
	}
	
	  private static void OpenImage(String path) throws IOException
	  {
	    SwingUtilities.invokeLater(new Runnable()
	    {
	      public void run()
	      {
	        JFrame Frame = new JFrame("Image");	        
	        BufferedImage image = null;
	        try
	        {
				String filePath = new File(path).getAbsolutePath();
				System.out.println(filePath);
				//File file = new File(filePath);
				image = ImageIO.read(new File(filePath));
	          //C:/Users/Binu/Desktop/shit/Angry-Beaver/Resources/Textures/Background/ExampleBackground.png
	        }
	        catch (Exception e)
	        {
	          e.printStackTrace();
	          System.exit(1);
	        }
	        ImageIcon imageIcon = new ImageIcon(image);
	        JLabel jLabel = new JLabel();
	        jLabel.setIcon(imageIcon);
	        Frame.getContentPane().add(jLabel, BorderLayout.CENTER);

	        Frame.pack();
	        Frame.setLocationRelativeTo(null);
	        Frame.setVisible(true);
	      }
	    });
	  }

	public Map<String, String> getImageMap() {
		return imageMap;
	}
}
