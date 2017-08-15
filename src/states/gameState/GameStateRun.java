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
import hitbox.Hitbox;
import keyInputs.ACTIONS;
import model.BeaverModel;
import model.CrateModel;
import model.DeerModel;
import model.PlatformModel;
import model.TreeModel;
import resourceHandling.Resource;
import resourceHandling.ResourceCollection;

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
		// Player		
		PlayerBehaviour playerBehaviour = new PlayerBehaviour();
		AbstractEntity player = new Beaver(new BeaverModel());
		player.setBehaviour(playerBehaviour);
		Hitbox playerh= new Hitbox(2, 2, 20, 15);
		playerh.setBody(true);
		player.addHitbox(playerh);
		player.setScaling(2.5);
		player.setId("Player");
		player.setPosition(new Point(400, 200));

		// Platform
		AbstractEntity p1 = new BasicPlatform(new PlatformModel());
		Hitbox plath =  new Hitbox(800, 50);
		plath.setSolid(true);
		p1.addHitbox(plath);
		p1.setStatic(true);
		p1.setPosition(new Point(350,300));
		
		// Tree
		AbstractEntity tree = new Tree(new TreeModel());
		tree.setPosition(new Point(500, 150));
		tree.addHitbox(new Hitbox(0, 0, 35, 21));
		Hitbox treeh1 = new Hitbox(11, 21, 9, 42);
		treeh1.setBody(true);
		tree.addHitbox(treeh1);
		tree.setScaling(3);
		tree.setHealth(5);
		
		// Crate
		AbstractEntity crate = new Crate(new CrateModel());
		crate.setPosition(new Point(800, 200));
		Hitbox crateh1 = new Hitbox(2, 2, 15, 15);
		crateh1.setSolid(true);
		crateh1.setBody(true);
		crate.addHitbox(crateh1);
		crate.setScaling(2);
		crate.setHealth(3);
		
		// Deer
		/* A Beaver is temporarily in use as Deer assets are being made
		AbstractEntity deer = new Deer(new DeerModel());
		// TODO: Add Deer Behaviour
		deer.setPosition(new Point(950, 250));
		Hitbox deerh1 = new Hitbox(15, 7, 33, 30);
		deerh1.setBody(true);
		deer.addHitbox(deerh1);
		deer.setScaling(3);
		deer.setHealth(3);
		*/

		AbstractEntity beaver = new Beaver(new BeaverModel());
		beaver.setPosition(new Point(950, 250));
		Hitbox beaverh1= new Hitbox(2, 2, 20, 15);
		beaverh1.setBody(true);
		beaver.addHitbox(beaverh1);
		beaver.setScaling(3);
		beaver.setHealth(3);
		
		// Add player into the level
		level.addEntity(player);
		// Set Camera to follow the player
		level.focusCamera(player);
		// Set HUD to display information related to the player
		level.focusHUD(player);
		level.displayHud(true);
		// Add other entities into the level
		level.addEntity(p1);
		level.addEntity(tree);
		level.addEntity(crate);
		//level.addEntity(deer);
		level.addEntity(beaver);
		
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
