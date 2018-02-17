package states.entityState.lodgeStates;

import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;
import trigger.TriggerFactory;

/**
 * Class LodgeState1 is an Entity State for Lodges where the Lodge
 * is incomplete. When the Lodge gains more health, then
 * the Lodge will move to a Complete State
 *
 */
public class LodgeState1 extends EntityStateAbstract {

	public LodgeState1(EntityStateContext context) {
		super(context);
		context.setTrigger(new TriggerFactory().createTrigger("Lodge"));
	}

	@Override
	public void checkForNextState() {
		if (context.getHealth() == 2) {
			context.setEntityState(new LodgeStateComplete(context));
		}
	}

	@Override
	public String stateToString() {
		return "Lodge State 1";
	}

}
