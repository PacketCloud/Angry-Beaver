package engine;

import javax.swing.JFrame;

/* 
 * MainRuntime is the class which will get window settings
 * 	and initialize a window frame to start the game.
 */
public class MainRuntime {

	LevelHandler lHandler;
	JFrame frame = new JFrame();
	
	// This initializes the game settings. We can later save
	// User settings in a file to read and set them here
	public MainRuntime() {
		initFrame("Angry-Beaver", 1280, 720);
	}
	
	public void readSettings() {
		//TODO: Read settings
	}
	
	public void initFrame(String title, int width, int height) {
		lHandler = new LevelHandler(this, width, height);
		
		frame.setTitle(title);
		frame.setSize(width, height);
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
