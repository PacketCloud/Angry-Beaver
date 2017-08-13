package states.entityState;

import states.entityState.basicEntityStates.BasicEntityStateDying;

public class NoEntityState extends EntityStateAbstract {

	public NoEntityState(EntityStateContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String stateToString() {
		// TODO Auto-generated method stub
		return "NoEntityState";
	}

	@Override
	public void checkForNextState() {
		// TODO Auto-generated method stub
		if (context.getHealth() == 0) {
			context.setEntityState(new BasicEntityStateDying(context));
		}
	}

}
