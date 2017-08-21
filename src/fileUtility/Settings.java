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
	int maxFPS;
	
	public Settings() {
		// Default settings
		setTitle("");
		setWindowSize(new Dimension(1920, 1080));
		isFullscreen = true;
		maxFPS = 60;
	}
	
	public void loadUserSettings() {
		// Go to OpenFile to open and parse settings.cfg		
		
		OpenFile settingFile = new OpenFile("/Settings.cfg");
		while(settingFile.hasNextLine()) {
			String[] split = settingFile.getNextLine().split("=", 2);
			parseLine(split);
		 }
		 settingFile.close();
	}
	
	// Method currently not in use
	public void saveUserSettings() {
		// Go to WriteFile to format and write to settings.cfg
		
		WriteFile settingFile = new WriteFile("/Settings.cfg");
		settingFile.writeln("#This file will be used to save/load game settings.");
		settingFile.writeln("#One setting per line.");
		settingFile.close();
	}
	
	public void parseLine(String[] split) {
		// More cases should be added as more Settings features are defined
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
 		case "max_fps":
 			setMaxFPS(Integer.valueOf(split[1]));
 			break;
		}
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

	public int getMaxFPS() {
		return maxFPS;
	}

	public void setMaxFPS(int max_fps) {
		this.maxFPS = max_fps;
	}	
}
