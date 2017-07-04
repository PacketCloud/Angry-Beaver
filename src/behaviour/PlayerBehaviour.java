package behaviour;

import java.util.Iterator;
import java.util.Set;

import entities.AbstractEntity;
import keyInputs.ACTIONS;

public class PlayerBehaviour extends AbstractBehaviour {
	
	public PlayerBehaviour() {
		super();
	}
	
	public void run(AbstractEntity entity) {
		Set<String> inputSet = entity.getLevel().getInput();
		
		Iterator<String> itr = inputSet.iterator();
		while(itr.hasNext()) {
			behaviour(itr.next(), entity);
		}
	}
}
