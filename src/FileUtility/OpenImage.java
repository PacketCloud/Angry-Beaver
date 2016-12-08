package FileUtility;

import java.awt.Image;
import java.io.*;
import javax.swing.*;

public class OpenImage {
	
	public OpenImage() {
		
	}
	
	  public Image Open(String Path) throws IOException
	  {
		  File file = new File("");
		  String absPath = file.getAbsolutePath();
		  Image image = null;
		  try{
			  image = new ImageIcon(absPath + Path).getImage();
		  } catch (Exception e){}
		  return image;
	  }
}
