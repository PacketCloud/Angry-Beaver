import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

/* Brief: MainRuntime is the class which will initialize
 * 		a window and the game loop. Images will be drawn
 * 		inside the window and updated by the game loop.
 */
public class MainRuntime extends JFrame {
	
	// Currently this sets a point to 0.
	public static int x = 0;
	// This is a list of Entities which can be used to track all
	// entities in the game.
	private ArrayList<Entity> entityList = new ArrayList<Entity>();
	
	public static void main(String[] args) {
		// Opens a 1920x1080 window to start the game
<<<<<<< HEAD
		MainRuntime gameWindow = new MainRuntime();
		gameWindow.runLoop();
		System.exit(0);
=======
		JFrame frame = new JFrame();
		frame.setSize(1280, 720);
		frame.setResizable(false);
		frame.setVisible(true);


		Graphics graphics = frame.getGraphics();
		frame.paint(graphics);
>>>>>>> parent of 19ae1f6... Now draws a blue rectangle
	}
	
	// This initializes the game settings. We can later save
	// User settings in a file to read and set them here
	public void init(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	// This is the game loop
	// TODO: FPS handling?
	public void runLoop() {
		init("Angry-Beaver", 1080, 720);
        while(true)
        {
                draw();
        }
	}
	
	// Draw a blank Graphics, then update and
	// draw the next movement.
	public void draw() {
		Graphics g = getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1080, 720);
		
		// Increment x by 1
		if(x != 500){
			x++;
		}
		
		g.setColor(Color.BLUE);
		g.fillRect(x, x, 100, 100);
	}
}
