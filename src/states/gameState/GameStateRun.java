package states.gameState;

import java.awt.Graphics2D;

import engine.LevelHandler;

public class GameStateRun extends GameStateAbstract {

	public GameStateRun(LevelHandler h) {
		super(h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO: Consider how to load the next level.
		getH().getCurrentLevel().updateLevel();
		System.out.println("Running");
		getH().repaint();
	}
	
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		super.pause();
		getH().getGameState().statePause();
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		getH().getCurrentLevel().drawLevel(g);
	}
}
