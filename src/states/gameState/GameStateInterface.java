package states.gameState;

import engine.*;

public interface GameStateInterface {
	public void update(LevelHandler h);
	public void userInput(LevelHandler h, String action);	
}
