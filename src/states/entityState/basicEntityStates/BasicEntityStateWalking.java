package states.entityState.basicEntityStates;

import java.awt.Point;

import force.TimedForce;
import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

/**
 * Class BasicEntityStateWalking is a generalized Entity State for
 * entities which are Walking. 
 * (Moving left or right on the x-axis with no movement on the y-axis).
 */
public class BasicEntityStateWalking extends EntityStateAbstract {

	public BasicEntityStateWalking(EntityStateContext context) {
		super(context);
	}

	@Override
	public void up() {
		super.up();
		// Create a TimedForce with the entity's jump strength
		context.getEntity().addForce(new TimedForce(0, -context.getJumpStrength(), 500));
		context.setEntityState(new BasicEntityStateRising(context));
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
		int x = context.getEntity().getMoveSpeedX();
		context.translate(-context.getMoveSpeedX(), 0);
		context.getEntity().setFacingRight(false);
	}
	
	@Override
	public void attack() {
		super.attack();
		context.setEntityState(new BasicEntityStateAttack(context));
	}
	
	@Override
	public String stateToString() {
		return "Walking";
	}

	@Override
	public void checkForNextState() {
		Point curPos = context.getCurrentPosition();
		Point lastPos = context.getLastPosition();
		
		// Change state to falling if moving down on y axis		
		if ((curPos.y - lastPos.y) > 0){
			context.setEntityState(new BasicEntityStateFalling(context));
		}
		
		// Change state to idle if not moving on x axis
		if ((curPos.x - lastPos.x) == 0){
			context.setEntityState(new BasicEntityStateIdle(context));
		}
		
		if (context.getHealth() <= 0) {
			context.setEntityState(new BasicEntityStateDying(context));
		}
	}
}
