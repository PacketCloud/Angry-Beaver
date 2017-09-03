package behaviour;

import java.util.Iterator;
import java.util.Set;

import engine.Level;
import entities.AbstractEntity;
import keyInputs.ACTIONS;

public class PlayerBehaviour extends AbstractBehaviour {
	
	public PlayerBehaviour() {
		super();
	}

	@Override
	public void run(AbstractEntity entity, Level level) {
		Set<String> inputSet = level.getInput();
		System.out.println("Player Input : " + inputSet.toString() + "\n");
		
		Iterator<String> itr = inputSet.iterator();
		while(itr.hasNext()) {
			doAction(itr.next(), entity);
		}
	}
}
