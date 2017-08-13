package states.entityState.basicEntityStates;

import java.awt.Point;

import force.Force;
import force.TimedForce;
import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

public class BasicEntityStateIdle extends EntityStateAbstract {

	public BasicEntityStateIdle(EntityStateContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void up() {
		// TODO Auto-generated method stub
		super.up();
		// Create a TimedForce with the entity's jump strength
		context.getEntity().addForce(new TimedForce(0, -context.getJumpStrength(), 500));
		context.setEntityState(new BasicEntityStateRising(context));
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		super.right();
		context.translate(context.getMoveSpeedX(), 0);
		context.getEntity().setFacingRight(true);
		context.setEntityState(new BasicEntityStateWalking(context));
	}
	
	@Override
	public void left() {
		// TODO Auto-generated method stub
		super.left();
		context.translate(-context.getMoveSpeedX(), 0);
		context.getEntity().setFacingRight(false);
		context.setEntityState(new BasicEntityStateWalking(context));
	}
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		super.attack();
		context.setEntityState(new BasicEntityStateAttack(context));
	}

	@Override
	public String stateToString() {
		// TODO Auto-generated method stub
		return "Idle";
	}

	@Override
	public void checkForNextState() {
		// TODO Auto-generated method stub
				
		Point curPos = context.getCurrentPosition();
		Point lastPos = context.getLastPosition();
		
		// Change state to falling if moving down on y axis		
		if ((curPos.y - lastPos.y) > 0){
			context.setEntityState(new BasicEntityStateFalling(context));
		}
		
		if (context.getHealth() == 0) {
			context.setEntityState(new BasicEntityStateDying(context));
		}
	}
}
