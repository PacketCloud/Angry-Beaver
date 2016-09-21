package states.gameState;

import engine.LevelHandler;

public class GameStateRun extends GameStateAbstract {

	@Override
	public void update(LevelHandler h) {
		h.repaint();
		h.getKeymap().updatePlayerActions(h.getCurrentLevel());
		h.getCurrentLevel().updateLevel();
		h.repaint();
		System.out.println("Running");
	}
}
