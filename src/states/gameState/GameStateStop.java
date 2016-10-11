package states.gameState;

import java.awt.Graphics2D;

import engine.LevelHandler;

public class GameStateStop extends GameStateAbstract {

	public GameStateStop(LevelHandler h) {
		super(h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		System.out.println("Stopping");
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
	}
}
