 package states.gameState;

import java.awt.Dimension;
import java.awt.Graphics2D;
import states.gameState.*;
import engine.LevelHandler;
import engine.MainRuntime;

public class GameState {
	public GameStateAbstract state;
	double xScale;
	double yScale;
	
	public GameState(LevelHandler h) {
		stateStart(h);
		Dimension windowSize = MainRuntime.getSettings().getWindowSize();
		xScale = (double) windowSize.getWidth()/1920;
		yScale = (double) windowSize.getHeight()/1080;
	}


	public void stateStart(LevelHandler h) {
		// TODO Auto-generated method stub
		setGameState(new GameStateStart(h));
	}

	public void update() {
		state.update();
	}

	public void userInput(String actionType) {
		state.userInput(actionType);
	}
	
	public void stateStop() {
		setGameState(new GameStateStop(getStateH()));
	}
	
	public void stateMenu() {
		setGameState(new GameStateMenu(getStateH()));
	}
	
	public void stateRun() {
		setGameState(new GameStateRun(getStateH()));
	}
	
	public void statePause() {
		setGameState(new GameStatePause(getStateH()));
	}
	
	public LevelHandler getStateH() {
		return getState().getH();
	}
	
	private void setGameState(GameStateAbstract state) {
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
