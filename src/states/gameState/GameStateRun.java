package states.gameState;

import java.awt.Graphics2D;
import java.util.*;
import engine.LevelHandler;

public class GameStateRun extends GameStateAbstract {

	public Set<String> inputSet = new HashSet<String>();
	
	public GameStateRun(LevelHandler h) {
		super(h);
		// TODO Auto-generated constructor stub
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
		getH().getCurrentLevel().drawLevel(g);
	}
	
	@Override
	public void update() {
		// TODO: Consider how to load the next level.
		Iterator<String> itr = inputSet.iterator();
		while(itr.hasNext()) {
			super.userInput(itr.next());
		}
		getH().getCurrentLevel().updateLevel();
		System.out.println("Running");
		getH().repaint();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		super.pause();
		getH().getGameState().statePause();
	}
	
	@Override
	public void up() {
		// TODO Auto-generated method stub
		super.up();
		getH().getCurrentLevel().getOffset().translate(0, 5);
		getH().getCurrentLevel().getPlayer().translate(0, -5);
	}
	
	@Override
	public void down() {
		// TODO Auto-generated method stub
		super.down();
		getH().getCurrentLevel().getOffset().translate(0, -5);
		getH().getCurrentLevel().getPlayer().translate(0, 5);
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		super.right();
		getH().getCurrentLevel().getOffset().translate(-5, 0);
		getH().getCurrentLevel().getPlayer().translate(5, 0);
		getH().getCurrentLevel().getPlayer().setFacing(-1);
	}

	@Override
	public void left() {
		// TODO Auto-generated method stub
		super.left();
		getH().getCurrentLevel().getOffset().translate(5, 0);
		getH().getCurrentLevel().getPlayer().translate(-5, 0);
		getH().getCurrentLevel().getPlayer().setFacing(1);
	}
}
