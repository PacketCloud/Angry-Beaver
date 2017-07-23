package states.gameState;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.*;

import behaviour.NoBehaviour;
import behaviour.PlayerBehaviour;
import engine.Level;
import entities.*;
import hitbox.Hitbox;
import keyInputs.ACTIONS;
import resourceHandling.Resource;
import resourceHandling.ResourceCollection;
import states.entityState.EntityStateFactory;

public class GameStateRun extends GameStateAbstract {
	public Level currentLevel;
	
	public GameStateRun(GameStateContext context, Level level) {
		super(context);
		this.currentLevel = level;
	}
	
	public GameStateRun(GameStateContext context, String levelName) {
		super(context);
		// Level loading should be done with file utility
		this.currentLevel = loadLevel(levelName);
	}
	
	public Level loadLevel(String name) {
		Level level = new Level();
		
		// Player
		ResourceCollection PlayerResourceCollection = new ResourceCollection("Player");
		PlayerResourceCollection.add(new Resource("Beaver Walking", "/Resources/Sprites/Player/Beaver_Walking.gif", (float) 2.5, null, true, "Walking"));
		PlayerResourceCollection.add(new Resource("Beaver Idle", "/Resources/Sprites/Player/Beaver_Idle.png", (float) 2.5, null, true, "Idle"));
		PlayerBehaviour playerBehaviour = new PlayerBehaviour();
		BasicEntity player = new BasicEntity(PlayerResourceCollection);
		player.setBehaviour(playerBehaviour);
		player.addHitbox(new Hitbox(10,10));
		player.addHitbox(new Hitbox(10, 10, 10, 10));
		player.setScaling(2.5);

		// Platform
		ResourceCollection PlatformResourceCollection = new ResourceCollection("Platform");
		PlatformResourceCollection.add(new Resource("Grass1", "/Resources/Textures/Environment/grass1.png", (float) 2.5, null, true, "NoEntityState"));
		BasicPlatform p1 = new BasicPlatform(PlatformResourceCollection);
		p1.addHitbox(new Hitbox(800, 50));
		p1.setPosition(new Point(350,300));
		
		// Tree
		ResourceCollection TreeResourceCollection = new ResourceCollection("Tree");
		TreeResourceCollection.add(new Resource("Tree", "/Resources/Sprites/Entities/Tree.png", (float) 2.5, null, true, "Idle"));
		BasicEntity tree = new BasicEntity(TreeResourceCollection);
		tree.setPosition(new Point(500, 150));
		tree.setScaling(2);
		tree.addHitbox(new Hitbox(2, 2, 20, 20));
		
		level.addEntity(player);
		level.addEntity(p1);
		level.addEntity(tree);
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
			//inputSet.remove(action.substring(2));
		} else {
			currentLevel.addInput(action);
			//inputSet.add(action);
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
		/*Iterator<String> itr = inputSet.iterator();
		while(itr.hasNext()) {
			super.userInput(itr.next());
		}*/
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
	
	@Override
	public void up() {
		// TODO Auto-generated method stub
		super.up();
		/*
		currentLevel.getOffset().translate(0, 5);
		currentLevel.getPlayer().translate(0, -5);
		*/
	}
	
	@Override
	public void down() {
		// TODO Auto-generated method stub
		super.down();
		/*currentLevel.getOffset().translate(0, -5);
		currentLevel.getPlayer().translate(0, 5);*/
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		super.right();
		/*currentLevel.getOffset().translate(-5, 0);
		currentLevel.getPlayer().translate(5, 0);
		currentLevel.getPlayer().setFacing(-1);*/
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		super.left();
		/*currentLevel.getOffset().translate(5, 0);
		currentLevel.getPlayer().translate(-5, 0);
		currentLevel.getPlayer().setFacing(1);*/
	}
}
