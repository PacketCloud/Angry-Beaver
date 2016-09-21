package states.gameState;

import engine.*;

public interface GameStateInterface {
	public void update(LevelHandler h);
	
/*	All actions in the game should be defined here
 * 		These actions will then be called by the Keymap
 * 		class and will be dealt with depending on the current
 * 		GameState.
 * 
	public void left(LevelHandler h);
	public void right(LevelHandler h);
	public void down(LevelHandler h);
	public void up(LevelHandler h);
	public void attack(LevelHandler h);
	public void pause(LevelHandler h);
	
	public void left(LevelHandler h);
	public void right(LevelHandler h);
	public void down(LevelHandler h);
	public void up(LevelHandler h);
	*/
}
