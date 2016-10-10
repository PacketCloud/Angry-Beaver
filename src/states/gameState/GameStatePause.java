package states.gameState;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.LevelHandler;

public class GameStatePause extends GameStateAbstract {
	
	public GameStatePause(LevelHandler h) {
		super(h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		getH().repaint();
    	System.out.println("Paused");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		super.pause();
		getH().getGameState().stateRun();
	}

	@Override
	public void render(Graphics2D g) {
		// TODO: Create a pause menu here
		g.setColor(Color.WHITE);
		g.scale(5, 5);
		g.drawString("Paused", 100, 100);
	}
}
