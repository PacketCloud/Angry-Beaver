package engine;

import javax.swing.JFrame;
import FileUtility.*;
/* 
 * MainRuntime is the class which will get window settings
 * 	and initialize a window frame to start the game.
 */
public class MainRuntime {

	LevelHandler lHandler;
	Settings fSettings;
	JFrame frame = new JFrame();
	
	// This initializes the game settings. We can later save
	// User settings in a file to read and set them here
	public MainRuntime() {
		initFrame();
	}
	
	public void loadSettings() {
		fSettings = new Settings();
	}
	
	public void initFrame() {
		loadSettings();
		lHandler = new LevelHandler(this, fSettings.getWindowSize());
		
		frame.setTitle(fSettings.getTitle());
		frame.setSize(fSettings.getWindowSize());
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(lHandler);
	}
	
	public void startGame() {
		lHandler.runLoop();
	}
	
	public static void main(String[] args) {
		MainRuntime gameWindow = new MainRuntime();
		gameWindow.startGame();
		System.exit(0);
	}
}
