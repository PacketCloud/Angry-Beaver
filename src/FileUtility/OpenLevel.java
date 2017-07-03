package fileUtility;

import java.util.HashMap;
import java.util.Map;

import engine.Level;

/*
 * 	OpenLevel contains a map of all Level Keys to their Directories.
 * 		It will return an Level when given a key. 
 */

public class OpenLevel {
	private Map<String, String> imageMap = new HashMap<String, String>();
	
	public OpenLevel() {
		//TODO: Initialize Key to Directory mapping for all images
	}
	
	public Level getLevel(String levelName) {
		//TODO: Use the map to use OpenFile and parse a Level file
		
		/*
		 * Level loadedLevel = new Level();
		 * OpenFile levelFile = new OpenFile(getImageMap().get(leveName));
		 * while(leveFile.hasNextLine()) {
		 * 		//Parse Line
		 * }
		 * 
		 * levelFile.close();
		 * 
		 * return loadedLevel;
		 */
		
		return null;
	}

	public Map<String, String> getImageMap() {
		return imageMap;
	}
}
