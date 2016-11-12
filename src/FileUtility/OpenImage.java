package FileUtility;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.*;
import javax.swing.*;

import entities.Hitbox;

/*
 * 	OpenImage contains a map of all Image Keys to their Directories.
 * 		It will return an Image when given a key. 
 */
public class OpenImage {
	private Map<String, String> imageMap = new HashMap<String, String>();
	
	public static void main(String[] args) throws IOException
	  {
		//OpenImage("Resources/Textures/Background/ExampleBackground.png");
	  }
	
	public OpenImage() {
		//TODO: Initialize Key to Directory mapping for all images
		//Example: getImageMap().put("Beaver", "/Resources/Sprites/Player/Beaver_Walking.gif");
	}
	
	  public Image OpenImage(String Path) throws IOException
	  {
		  File file = new File("");
		  String absPath = file.getAbsolutePath();
		  Image image = null;
		  try{
			  image = new ImageIcon(absPath + Path).getImage();
		  } catch (Exception e){}
		  return image;
	  }

	public Map<String, String> getImageMap() {
		return imageMap;
	}
}
