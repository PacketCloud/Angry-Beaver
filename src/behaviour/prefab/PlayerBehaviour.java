package behaviour.prefab;

import java.util.Iterator;
import java.util.Set;

import behaviour.AbstractBehaviour;
import engine.Level;
import entities.AbstractEntity;

/**
 * Class PlayerBehaviour takes inputs from the Player.
 * 
 * An entity with the PlayerBehaviour class will be controlled
 * by the Player.
 */

public class PlayerBehaviour extends AbstractBehaviour {
	
	public PlayerBehaviour() {
		super();
	}

	@Override
	public void run(AbstractEntity entity, Level level) {
		// Get inputs from player and do actions
		Set<String> inputSet = level.getInput();
		
		Iterator<String> itr = inputSet.iterator();
		while(itr.hasNext()) {
			doAction(itr.next(), entity);
		}
	}
}
