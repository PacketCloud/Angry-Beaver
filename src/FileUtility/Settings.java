package FileUtility;

import java.awt.Dimension;

public class Settings {
	String title;
	Dimension windowSize;
	
	public Settings() {
		loadUserSettings();
	}
	
	public void loadUserSettings() {
		// Go to OpenFile to open and parse settings.cfg
		// It should have default values if certain values can not be found
		setTitle("Angry-Beaver");
		setWindowSize(new Dimension(1280, 720));
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
