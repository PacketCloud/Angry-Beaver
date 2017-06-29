 package states.gameState;

import java.awt.Dimension;
import java.awt.Graphics2D;
import states.gameState.*;
import engine.GameHandler;
import engine.MainRuntime;

public class GameStateContext {
	public GameStateAbstract state;
	public GameHandler h;
	double xScale;
	double yScale;
	
	public GameStateContext(GameHandler h) {
		this.h = h;
		initState();
		Dimension windowSize = MainRuntime.getSettings().getWindowSize();
		xScale = (double) windowSize.getWidth()/1920;
		yScale = (double) windowSize.getHeight()/1080;
	}


	public void initState() {
		// TODO Auto-generated method stub
		setGameState(new GameStateStart(this));
	}

	public void update() {
		state.update();
	}
	
	public void repaint() {
		h.repaint();
	}

	public void userInput(String actionType) {
		state.userInput(actionType);
	}
	
	public void setGameState(GameStateAbstract state) {
		this.state = state;
	}

	public GameStateAbstract getState() {
		return state;
	}

	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		g.scale(xScale, yScale);
		state.render(g);
	}
}
