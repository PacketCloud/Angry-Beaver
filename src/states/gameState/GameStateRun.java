package states.gameState;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.*;

import ResourceHandling.Resource;
import ResourceHandling.ResourceCollection;
import engine.GameHandler;
import engine.Level;
import entities.Entity;
import entities.Hitbox;
import entities.Platform;

public class GameStateRun extends GameStateAbstract {
	public Level currentLevel;
	public Set<String> inputSet = new HashSet<String>();
	
	public GameStateRun(GameStateContext context, Level level) {
		super(context);
		this.currentLevel = level;
	}
	
	public GameStateRun(GameStateContext context, String levelName) {
		super(context);
		// Level loading should be done with file utility
		currentLevel = loadLevel(levelName);
	}
	
	public Level loadLevel(String levelName) {
		Level level = new Level();
		// This should be done using FileUtility instead of here. Temp solution instead of FileUtility
		Platform platform = new Platform(new Hitbox(new Point(150, 300), 800, 50));
		Platform platform2 = new Platform(new Hitbox(new Point(900, 400), 50, 200));
		
		//This is temporary, should be done elsewhere as the level loads.
		ResourceCollection PlayerResourceCollection = new ResourceCollection("Player");
		PlayerResourceCollection.add(new Resource("Beaver Walking", "/Resources/Sprites/Player/Beaver_Walking.gif", (float) 2.5, null, true, "Walking"));
			
		Entity player = new Entity(new Point(0,0), new Hitbox(new Point(0,0), 50, 50), PlayerResourceCollection, -1, "Walking");
		
		level.addPlatform(platform);
		level.addPlatform(platform2);
		level.setPlayer(player);
		return level;
	}
	
	@Override
	public void userInput(String action) {
		// TODO Auto-generated method stub
		if (action.startsWith("r_")) {
			inputSet.remove(action.substring(2));
		} else {
			inputSet.add(action);
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
		Iterator<String> itr = inputSet.iterator();
		while(itr.hasNext()) {
			super.userInput(itr.next());
		}
		currentLevel.updateLevel();
		System.out.println("Running");
		context.repaint();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		super.pause();
		context.setGameState(new GameStatePause(context, currentLevel));
	}
	
	@Override
	public void up() {
		// TODO Auto-generated method stub
		super.up();
		currentLevel.getOffset().translate(0, 5);
		currentLevel.getPlayer().translate(0, -5);
	}
	
	@Override
	public void down() {
		// TODO Auto-generated method stub
		super.down();
		currentLevel.getOffset().translate(0, -5);
		currentLevel.getPlayer().translate(0, 5);
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		super.right();
		currentLevel.getOffset().translate(-5, 0);
		currentLevel.getPlayer().translate(5, 0);
		currentLevel.getPlayer().setFacing(-1);
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		super.left();
		currentLevel.getOffset().translate(5, 0);
		currentLevel.getPlayer().translate(-5, 0);
		currentLevel.getPlayer().setFacing(1);
	}
}
