package states.entityState.lodgeStates;

import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

public class LodgeStateComplete extends EntityStateAbstract {

	public LodgeStateComplete(EntityStateContext context) {
		super(context);
	}

	@Override
	public void checkForNextState() {
		
	}

	@Override
	public String stateToString() {
		return "Lodge Complete";
	}
}
