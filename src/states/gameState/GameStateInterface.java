package states.gameState;

import java.awt.Graphics2D;

import engine.*;

/*
 * GameStateInterface ensures that updating, rendering graphics,
 * 		and input methods exist in the class.
 */
public interface GameStateInterface {
	public void update(LevelHandler h);
	public void userInput(LevelHandler h, String action);
	public void render(LevelHandler h, Graphics2D g);
	
	public void up(LevelHandler h);
	public void down(LevelHandler h);
	public void right(LevelHandler h);
	public void left(LevelHandler h);
	
	public void r_up(LevelHandler h);
	public void r_down(LevelHandler h);
	public void r_right(LevelHandler h);
	public void r_left(LevelHandler h);
	public void pause(LevelHandler h);
	public void jump(LevelHandler h);
	public void attack(LevelHandler h);
	public void iThrow(LevelHandler h);
}
