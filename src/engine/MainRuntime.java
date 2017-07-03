package engine;

import javax.swing.JFrame;

import fileUtility.*;
/* 
 * MainRuntime is the class which will get window settings
 * 	and initialize a window frame to start the game.
 */
public class MainRuntime {

	private GameHandler lHandler;
	private static Settings fSettings;
	private JFrame frame = new JFrame();
	
	// This initializes the game settings. We can later save
	// User settings in a file to read and set them here
	public MainRuntime() {
		initFrame();
	}
	
	public void loadSettings() {
		fSettings = new Settings();
		fSettings.loadUserSettings();
	}
	
	public void initFrame() {
		loadSettings();
		lHandler = new GameHandler();
		
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
