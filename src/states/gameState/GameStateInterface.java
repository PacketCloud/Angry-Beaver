package states.gameState;

import java.awt.Graphics2D;

import engine.*;

/*
 * GameStateInterface ensures that updating, rendering graphics,
 * 		and input methods exist in the class. This class will be
 * 		restructured later after implementing Level Reading
 * 		and Behaviors.
 */
public interface GameStateInterface {
	public void update();
	public void userInput(String action);
	public void render(Graphics2D g);
	
	public void up();
	public void down();
	public void right();
	public void left();
	
	public void r_up();
	public void r_down();
	public void r_right();
	public void r_left();
	public void pause();
	public void jump();
	public void attack();
	public void iThrow();
}
