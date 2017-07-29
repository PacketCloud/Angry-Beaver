package fileUtility;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;

import javax.swing.ImageIcon;

public class OpenImage {
	
	public OpenImage() {
		
	}
	
	  public Image Open(String Path) throws IOException
	  {
		  File file = new File("");
		  String absPath = file.getAbsolutePath();
		  Image image = null;
		  try{
			  //Toolkit t = Toolkit.getDefaultToolkit();
			  //image = t.getImage(absPath + Path);
			  			  
			  image = new ImageIcon(absPath + Path).getImage();
			  //image.flush();
		  } catch (Exception e){}
		  return image;
	  }
}
