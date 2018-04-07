 package states.gameState;

import java.awt.Dimension;
import java.awt.Graphics2D;
import engine.GameHandler;
import fileUtility.Settings;

/**
 * Class GameStateContext is the context class for Game States.
 */
public class GameStateContext {
	public GameStateAbstract state;
	public GameHandler h;
	double xScale;
	double yScale;
	
	public GameStateContext(GameHandler h) {
		this.h = h;
		initState();
		Dimension windowSize = Settings.getInstance().getWindowSize();
		xScale = (double) windowSize.getWidth()/1920;
		yScale = (double) windowSize.getHeight()/1080;
	}

	public void initState() {
		setGameState(new GameStateStart(this));
	}

	public void update() {
		state.update();
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
		g.scale(xScale, yScale);
		state.render(g);
	}
}
