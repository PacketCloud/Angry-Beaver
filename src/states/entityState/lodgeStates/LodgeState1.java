package states.entityState.lodgeStates;

import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

public class LodgeState1 extends EntityStateAbstract {

	public LodgeState1(EntityStateContext context) {
		super(context);
	}

	@Override
	public void checkForNextState() {
		
	}

	@Override
	public String stateToString() {
		return "Lodge State 1";
	}

}
