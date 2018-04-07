package fileUtility;

import java.awt.Image;
import java.io.*;

import javax.swing.ImageIcon;
/**
 * Class OpenFile is used to open image files.
 *
 */
public class OpenImage {
	
	public OpenImage() {
		
	}
	
	public Image Open(String Path) throws IOException {
		  File file = new File("");
		  String absPath = file.getAbsolutePath();
		  Image image = null;
		  try{			  			  
			  image = new ImageIcon(absPath + Path).getImage();
		  } catch (Exception e){
			  System.out.println(e);
		  }
		  return image;
	  }
}
