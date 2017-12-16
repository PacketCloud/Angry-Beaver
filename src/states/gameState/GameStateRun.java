package states.gameState;

import java.awt.Graphics2D;
import java.awt.Point;

import behaviour.PlayerBehaviour;
import engine.Level;
import entities.*;
import entities.prefab.Beaver;
import entities.prefab.Crate;
import entities.prefab.Deer;
import entities.prefab.Tree;
import fileUtility.OpenLevel;
import hitbox.Hitbox;
import keyInputs.ACTIONS;

public class GameStateRun extends GameStateAbstract {
	public Level currentLevel;
	
	public GameStateRun(GameStateContext context, Level level) {
		super(context);
		this.currentLevel = level;
	}
	
	public GameStateRun(GameStateContext context, String levelName) {
		super(context);
		// TODO: Level loading should be done with file utility
		this.currentLevel = loadLevel(levelName);
	}
	
	public Level loadLevel(String name) {
		Level level = new Level();
		// TODO: Level loading should be done with file utility
		OpenLevel openLevel = new OpenLevel();
		level = openLevel.parseLevel(name);
		
		// Beaver
		AbstractEntity beaver = new Beaver();
		beaver.setPosition(new Point(400, 200));
		beaver.setScaling(2.5);
		beaver.setHealth(3);
		
		// Deer
		AbstractEntity deer = new Deer();
		deer.setPosition(new Point(950, 250));
		deer.setScaling(3);
		deer.setHealth(3);
		
		
		// Platform
		AbstractEntity platform = new BasicPlatform();
		Hitbox plath =  new Hitbox(800, 50);
		plath.setSolid(true);
		platform.addHitbox(plath);
		platform.setStatic(true);
		platform.setPosition(new Point(350,300));
		
		// Tree
		AbstractEntity tree = new Tree();
		tree.setPosition(new Point(500, 150));
		tree.setScaling(3);
		tree.setHealth(5);
		
		// Crate
		AbstractEntity crate = new Crate();
		crate.setPosition(new Point(800, 200));
		crate.setScaling(2);
		crate.setHealth(3);
		
		// Set behaviour, ID, camera, and HUD to player
		AbstractEntity player = deer;
		PlayerBehaviour playerBehaviour = new PlayerBehaviour();
		player.setBehaviour(playerBehaviour);
		player.setId("Player");
		level.focusCamera(player);
		level.focusHUD(player);
		level.displayHud(true);

		// Add all entities into the level
		level.addEntity(beaver);
		level.addEntity(deer);
		level.addEntity(platform);
		level.addEntity(tree);
		level.addEntity(crate);
		
		return level;
	}
	
	@Override
	public void userInput(String action) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		currentLevel.drawLevel(g);
	}
	
	@Override
	public void update() {
		// TODO: Consider how to load the next level.
		currentLevel.updateLevel();
		System.out.println("Running");
		//context.repaint();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		super.pause();
		context.setGameState(new GameStatePause(context, currentLevel));
	}
}
