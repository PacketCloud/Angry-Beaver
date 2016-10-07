package states.gameState;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.LevelHandler;

public class GameStateStop extends GameStateAbstract {

	@Override
	public void update(LevelHandler h) {
		System.out.println("Stopping");
		h.setIsRunning(false);	
	}

	@Override
	public void render(LevelHandler h, Graphics2D g) {
		// TODO Auto-generated method stub
	}
}
