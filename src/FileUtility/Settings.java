package FileUtility;

import java.awt.Dimension;

/*
 * 	The Settings class loads Default Settings on creation.
 * 		Using loadUserSettings() will open settings.cfg and 
 * 		parse the contents. 
 */

public class Settings {
	String title;
	Dimension windowSize;
	
	public Settings() {
		setTitle("");
		setWindowSize(new Dimension(1280, 720));
	}
	
	public void loadUserSettings() {
		// Go to OpenFile to open and parse settings.cfg
		// Temporary settings
		setTitle("Angry-Beaver");
		setWindowSize(new Dimension(1280, 720));
		
		/*
		 * OpenFile settingFile = new OpenFile("/Settings.cfg");
		 * while(settingFile.hasNextLine()) {
		 * 		String[] split = settingFile.getNextLine().split("=", 2);
		 * 		switch (split[0].toLowerCase()) {
		 * 			case "title":
		 * 				break;
		 * 			case "resolution":
		 * 				break;
		 * 			// More cases should be added as more Settings features are defined
		 * 		}
		 * }
		 * settingFile.close();
		 */
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Dimension getWindowSize() {
		return windowSize;
	}

	public void setWindowSize(Dimension windowSize) {
		this.windowSize = windowSize;
	}

}
