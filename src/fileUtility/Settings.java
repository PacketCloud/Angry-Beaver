package fileUtility;

import java.awt.Dimension;

/**
 * The Settings class loads Default Settings on creation.
 * It will then open and parse settings.cfg for Player Settings 
 */
public class Settings {
	
	private static Settings settingsInstance = null;
	
	private String title;
	private Dimension windowSize;
	private boolean isFullscreen;
	private int maxFPS;
	private boolean isDevelopment;
	
	private Settings() {
		// Default settings
		setTitle("");
		setWindowSize(new Dimension(1920, 1080));
		setFullscreen(true);
		setMaxFPS(60);
		setDevelopment(true);
	}
	
	public static Settings getInstance() {
		if (settingsInstance == null) {
			Settings userSettings = new Settings();
			userSettings.loadUserSettings();
			settingsInstance = userSettings;
		}
		
		return settingsInstance;
	}
	
	/**
	 * Method loadUserSettings will open and parse settings.cfg
	 * for Player Settings
	 */
	public void loadUserSettings() {
		OpenFile settingFile = new OpenFile("/Settings.cfg");
		while(settingFile.hasNextLine()) {
			String[] split = settingFile.getNextLine().split("=", 2);
			parseLine(split);
		 }
		 settingFile.close();
	}
	
	/**
	 * Method saveUserSettings will save the defined settings values of 
	 * the instance into settings.cfg
	 */
	public void saveUserSettings() {
		// Go to WriteFile to format and write to settings.cfg
		
		WriteFile settingFile = new WriteFile("/Settings.cfg");
		settingFile.writeln("#This file will be used to save/load game settings.");
		settingFile.writeln("#One setting per line.");
		settingFile.writeln("title=" + title);
		settingFile.writeln("width=" + (int) windowSize.getWidth());
		settingFile.writeln("height=" + (int) windowSize.getHeight());
		
		int holder = 0;
		if(isFullscreen) {
			holder = 1;
		}
		
		settingFile.writeln("fullscreen=" + holder);
		settingFile.writeln("max_fps=" + maxFPS);
		
		settingFile.close();
	}
	
	/**
	 * Method parseLine will parse a given set of strings as Settings values
	 * 
	 * @param split 		A String array
	 */
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

	public void setFullscreen(boolean fullscreen) {
		this.isFullscreen = fullscreen;
	}

	public int getMaxFPS() {
		return maxFPS;
	}

	public void setMaxFPS(int max_fps) {
		this.maxFPS = max_fps;
	}

	public boolean isDevelopment() {
		return isDevelopment;
	}

	public void setDevelopment(boolean isDevelopment) {
		this.isDevelopment = isDevelopment;
	}
	
}
