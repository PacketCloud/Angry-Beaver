package states.gameState;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.LevelHandler;

public class GameStatePause extends GameStateAbstract {
	
	@Override
	public void update(LevelHandler h) {
		h.repaint();
    	System.out.println("Paused");
	}

	@Override
	public void pause(LevelHandler h) {
		// TODO Auto-generated method stub
		super.pause(h);
		h.getGameState().stateRun();
	}

	@Override
	public void render(LevelHandler h, Graphics2D g) {
		// TODO: Create a pause menu here
		g.setColor(Color.WHITE);
		g.scale(5, 5);
		g.drawString("Paused", 100, 100);
	}
}
