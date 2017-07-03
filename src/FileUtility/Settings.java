package fileUtility;

import java.awt.Dimension;

/*
 * 	The Settings class loads Default Settings on creation.
 * 		Using loadUserSettings() will open settings.cfg and 
 * 		parse the contents. 
 */

public class Settings {
	String title;
	Dimension windowSize;
	boolean isFullscreen;
	
	public Settings() {
		// Default settings
		setTitle("");
		setWindowSize(new Dimension(1920, 1080));
		isFullscreen = true;
	}
	
	public void loadUserSettings() {
		// Go to OpenFile to open and parse settings.cfg		
		
		OpenFile settingFile = new OpenFile("/Settings.cfg");
		while(settingFile.hasNextLine()) {
			String[] split = settingFile.getNextLine().split("=", 2);
		 	switch (split[0].toLowerCase()) {
		 		case "title":
		 			setTitle(split[1]);
		 			break;
		 		case "fullscreen":
		 			if(Integer.valueOf(split[1]) == 1) {
		 				isFullscreen = true;
		 			} else {
		 				isFullscreen = false;
		 			}
		 			break;
		 		case "width":
		 			windowSize.setSize(Integer.valueOf(split[1]), getWindowSize().getHeight());
		 			break;
		 		case "height":
		 			windowSize.setSize(getWindowSize().getWidth(), Integer.valueOf(split[1]));
		 			break;
		 		// More cases should be added as more Settings features are defined
		 	}
		 }
		 settingFile.close();
		
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

	public boolean isFullscreen() {
		return isFullscreen;
	}

	public void setisFullscreen(boolean fullscreen) {
		this.isFullscreen = fullscreen;
	}

}
