package states.entityState.basicEntityStates;

import entities.AbstractEntity;
import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

public class BasicEntityStateDying extends EntityStateAbstract{
	long startTime;
	
	// TODO: Transitions from other BasicEntityStates to Dying state
	public BasicEntityStateDying(EntityStateContext context) {
		super(context);
		
		startTime = System.nanoTime() / 1000000;
		AbstractEntity dropEntity = context.makeEntity(stateToString());
		
		if(dropEntity != null) {
			// Add claw as a sub-entity and as an entity in the level
			context.getEntity().getLevel().addEntity(dropEntity);
		}
	}

	@Override
	public void checkForNextState() {
		// TODO Auto-generated method stub
		
		long endTime = System.nanoTime() / 1000000 - startTime;
		// Give 1000 milliseconds before destroying the entity (Death Animation?)
		if(endTime > 1000){
			context.destroy();
		}
	}

	@Override
	public String stateToString() {
		// TODO Auto-generated method stub
		return "Dying";
	}

}
