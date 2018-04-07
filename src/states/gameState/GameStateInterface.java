package states.gameState;

import java.awt.Graphics2D;

/**
 * GameStateInterface ensures that updating, rendering graphics,
 * 		and input methods exist in the class.
 */
public interface GameStateInterface {
	public void update();
	public void userInput(String action);
	public void render(Graphics2D g);
	
	public void up();
	public void down();
	public void right();
	public void left();
	
	public void pause();
	public void jump();
	public void attack();
	public void attack2();
}
