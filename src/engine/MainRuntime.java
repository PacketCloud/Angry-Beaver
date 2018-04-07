package engine;

import javax.swing.JFrame;

import fileUtility.*;

/**
 * Class MainRuntime will get game settings and initialize the game window.
 */

public class MainRuntime {

	private GameHandler lHandler;
	private JFrame frame = new JFrame();
	
	public MainRuntime() {
		initFrame();
	}
	
	/**
	 * Method initFrame will use the game settings to initialize the game window 
	 */
	public void initFrame() {
		// Load game settings
		Settings settings = Settings.getInstance();
		lHandler = new GameHandler();
		
		// Set game settings
		frame.setTitle(settings.getTitle());
		frame.setSize(settings.getWindowSize());
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// If fullscreen is enabled
		if(settings.isFullscreen()) {
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
	
	public static void main(String[] args) {
		MainRuntime gameWindow = new MainRuntime();
		gameWindow.startGame();
		System.exit(0);
	}
}
