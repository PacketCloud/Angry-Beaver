package states.entityState.basicEntityStates;

import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

public class BasicEntityStateDying extends EntityStateAbstract{

	// TODO: Transitions from other BasicEntityStates to Dying state
	public BasicEntityStateDying(EntityStateContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkForNextState() {
		// TODO Auto-generated method stub
		context.destroy();
	}

	@Override
	public String stateToString() {
		// TODO Auto-generated method stub
		return "Dying";
	}

}
