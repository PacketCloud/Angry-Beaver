package engine;

import javax.swing.JFrame;

import fileUtility.*;

/**
 * Class MainRuntime will get game settings and initialize the game window.
 */

public class MainRuntime {

	private GameHandler lHandler;
	private static Settings fSettings;
	private JFrame frame = new JFrame();
	
	public MainRuntime() {
		initFrame();
	}
	
	public void loadSettings() {
		fSettings = new Settings();
		fSettings.loadUserSettings();
	}
	
	/**
	 * Method initFrame will use the game settings to initialize the game window 
	 */
	public void initFrame() {
		// Load game settings
		loadSettings();
		lHandler = new GameHandler();
		
		// Set game settings
		frame.setTitle(fSettings.getTitle());
		frame.setSize(fSettings.getWindowSize());
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// If fullscreen is enabled
		if(fSettings.isFullscreen()) {
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			frame.setUndecorated(true);
		}
		
		frame.setVisible(true);
		frame.add(lHandler);
		frame.pack();
	}
	
	public void startGame() {
		lHandler.runLoop();
	}
	
	public static Settings getSettings() {
		return fSettings;
	}
	
	public static void main(String[] args) {
		MainRuntime gameWindow = new MainRuntime();
		gameWindow.startGame();
		System.exit(0);
	}
}
