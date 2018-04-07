package states.entityState.basicEntityStates;

import java.awt.Point;

import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

/**
 * Class BasicEntityStateFalling is a generalized Entity State for
 * entities which are Falling (Moving down on the y-axis).
 */
public class BasicEntityStateFalling extends EntityStateAbstract {

	public BasicEntityStateFalling(EntityStateContext context) {
		super(context);
	}

	@Override
	public void right() {
		super.right();
		context.translate(context.getMoveSpeedX(), 0);
		context.getEntity().setFacingRight(true);
	}
	
	@Override
	public void left() {
		super.left();
		context.translate(-context.getMoveSpeedX(), 0);
		context.getEntity().setFacingRight(false);
	}
	
	@Override
	public void attack() {
		super.attack();
		context.setEntityState(new BasicEntityStateAttack(context));
	}
	
	@Override
	public void checkForNextState() {		
		Point curPos = context.getCurrentPosition();
		Point lastPos = context.getLastPosition();

		// Change to Idle if the entity stops moving on the y-axis
		if ((curPos.y - lastPos.y) == 0){
			context.setEntityState(new BasicEntityStateIdle(context));
		}
		
		// Change state to Rising if moving up on y axis
		if ((curPos.y - lastPos.y) < 0){
			context.setEntityState(new BasicEntityStateRising(context));
		}
		
		if (context.getHealth() <= 0) {
			context.setEntityState(new BasicEntityStateDying(context));
		}
	}

	@Override
	public String stateToString() {
		// TODO Auto-generated method stub
		return "Falling";
	}

}
