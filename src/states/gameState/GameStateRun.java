package states.gameState;

import engine.LevelHandler;

public class GameStateRun extends GameStateAbstract {

	@Override
	public void update(LevelHandler h) {
		h.repaint();
		h.getCurrentLevel().updateLevel();
		h.repaint();
		System.out.println("Running");
	}
	
	@Override
	public void pause(LevelHandler h) {
		// TODO Auto-generated method stub
		super.pause(h);
		h.getGameState().statePause();
	}
}
