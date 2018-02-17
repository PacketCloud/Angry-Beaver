package states.entityState.lodgeStates;

import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;
import trigger.TriggerFactory;

/**
 * Class LodgeStateComplete is an Entity State for Lodges where the
 * Lodge is complete. If the Player moves over the Lodge, the Player
 * will win.
 *
 */

public class LodgeStateComplete extends EntityStateAbstract {

	public LodgeStateComplete(EntityStateContext context) {
		super(context);
		context.setTrigger(new TriggerFactory().createTrigger("Win,Player"));
	}

	@Override
	public void checkForNextState() {
		
	}

	@Override
	public String stateToString() {
		return "Lodge Complete";
	}
}
