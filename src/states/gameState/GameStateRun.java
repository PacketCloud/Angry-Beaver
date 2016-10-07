package states.gameState;

import java.awt.Graphics2D;

import engine.LevelHandler;

public class GameStateRun extends GameStateAbstract {

	@Override
	public void update(LevelHandler h) {
		// TODO: Consider how to load the next level.
		h.getCurrentLevel().updateLevel();
		System.out.println("Running");
		h.repaint();
	}
	
	@Override
	public void pause(LevelHandler h) {
		// TODO Auto-generated method stub
		super.pause(h);
		h.getGameState().statePause();
	}

	@Override
	public void render(LevelHandler h, Graphics2D g) {
		// TODO Auto-generated method stub
		h.getCurrentLevel().drawLevel(g);
	}
}
