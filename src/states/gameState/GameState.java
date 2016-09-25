package states.gameState;

import engine.LevelHandler;

public class GameState {
	public GameStateAbstract state;
	
	public GameState() {
		stateRun();
	}

	public void update(LevelHandler h) {
		state.update(h);
	}

	public void userInput(LevelHandler h, String actionType) {
		state.userInput(h, actionType);		
	}
	
	public void stateStop() {
		setGameState(new GameStateStop());
	}

	public void stateRun() {
		setGameState(new GameStateRun());
	}
	
	public void statePause() {
		setGameState(new GameStatePause());
	}
	
	private void setGameState(GameStateAbstract state) {
		this.state = state;
	}
}
