package states.entityState;

import states.entityState.basicEntityStates.BasicEntityStateDying;

/**
 * Class NoEntityState is an Entity State which does no actions 
 * when an action is performed.
 */
public class NoEntityState extends EntityStateAbstract {

	public NoEntityState(EntityStateContext context) {
		super(context);
	}

	@Override
	public String stateToString() {
		return "NoEntityState";
	}

	@Override
	public void checkForNextState() {
		if (context.getHealth() <= 0) {
			context.setEntityState(new BasicEntityStateDying(context));
		}
	}

}
