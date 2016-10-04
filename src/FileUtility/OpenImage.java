package FileUtility;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;


public class OpenImage {
	
	
	public static void main(String[] args) throws IOException
	  {
		OpenImage();
	  }

	  private static void OpenImage() throws IOException
	  {
	    SwingUtilities.invokeLater(new Runnable()
	    {
	      public void run()
	      {
	        JFrame Frame = new JFrame("Image");	        
	        BufferedImage image = null;
	        try
	        {
	          image = ImageIO.read(new File("C:/Users/Binu/Desktop/shit/Angry-Beaver/src/FileUtility/Blank Space.png"));
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
}
