package states.gameState;

import java.awt.Font;
import java.awt.Graphics2D;

import engine.Level;

import fileUtility.OpenLevel;

import keyInputs.ACTIONS;

/**
 * Class GameStateRun is the Game State in which a Level can be played.
 */
public class GameStateRun extends GameStateAbstract {
	public Level currentLevel;
	
	public GameStateRun(GameStateContext context, Level level) {
		super(context);
		this.currentLevel = level;
	}
	
	public GameStateRun(GameStateContext context, String levelName) {
		super(context);
		this.currentLevel = loadLevel(levelName);
	}
	
	public Level loadLevel(String name) {
		Level level = new Level();
		OpenLevel openLevel = new OpenLevel();
		level = openLevel.parseLevel(name);
		return level;
	}
	
	@Override
	public void userInput(String action) {
		if (action.equals(ACTIONS.PAUSE)) {
			pause();
		}
		if (action.startsWith("r_")) {
			currentLevel.removeInput(action.substring(2));
		} else {
			currentLevel.addInput(action);
		}
	}

	@Override
	public void render(Graphics2D g) {
		g.setFont(new Font(gameTextFont, 0, gameTextSize));
		currentLevel.drawLevel(g);
	}
	
	@Override
	public void update() {
		// TODO: Consider how to load the next level.
		if(currentLevel.isLose()) {
			context.setGameState((new GameStateLose(context)));
		}
		if(currentLevel.isWin()) {
			context.setGameState((new GameStateWin(context)));
		}
		currentLevel.updateLevel();
		System.out.println("Running");
	}

	@Override
	public void pause() {
		super.pause();
		context.setGameState(new GameStatePause(context, currentLevel));
	}
}
