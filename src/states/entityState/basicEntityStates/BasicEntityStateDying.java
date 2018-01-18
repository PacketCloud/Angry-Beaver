package states.entityState.basicEntityStates;

import entities.AbstractEntity;
import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

/**
 * Class BasicEntityStateDying is a generalized Entity State for
 * entities which are dying (Have no health).
 *
 * The duration of the dying state is limited by a timer.
 */
public class BasicEntityStateDying extends EntityStateAbstract{
	private long startTime;
	
	public BasicEntityStateDying(EntityStateContext context) {
		super(context);
		
		// Set timer
		startTime = System.nanoTime() / 1000000;
		AbstractEntity dropEntity = context.makeEntity(stateToString());
		
		// If an entity is to be dropped when dying
		if(dropEntity != null) {
			context.getEntity().getLevel().addEntity(dropEntity);
		}
	}

	@Override
	public void checkForNextState() {		
		long endTime = System.nanoTime() / 1000000 - startTime;
		// Give 1000 milliseconds before destroying the entity (Death Animation?)
		if(endTime > 1000){
			context.destroy();
		}
	}

	@Override
	public String stateToString() {
		return "Dying";
	}

}
