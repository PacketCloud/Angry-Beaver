package states.entityState.basicEntityStates;

import java.awt.Point;

import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

public class BasicEntityStateFalling extends EntityStateAbstract {

	public BasicEntityStateFalling(EntityStateContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		super.right();
		context.translate(context.getMoveSpeedX(), 0);
		context.getEntity().setFacingRight(true);
	}
	
	@Override
	public void left() {
		// TODO Auto-generated method stub
		super.left();
		context.translate(-context.getMoveSpeedX(), 0);
		context.getEntity().setFacingRight(false);
	}
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		super.attack();
		context.setEntityState(new BasicEntityStateAttack(context));
	}
	
	@Override
	public void checkForNextState() {
		// TODO Auto-generated method stub
		
		Point curPos = context.getCurrentPosition();
		Point lastPos = context.getLastPosition();

		// Change to Idle if the entity stops moving on the y-axis
		if ((curPos.y - lastPos.y) == 0){
			context.setEntityState(new BasicEntityStateIdle(context));
		}
		
		// Change state to rising if moving up on y axis
		if ((curPos.y - lastPos.y) < 0){
			context.setEntityState(new BasicEntityStateRising(context));
		}
		
		if (context.getHealth() == 0) {
			context.setEntityState(new BasicEntityStateDying(context));
		}
	}

	@Override
	public String stateToString() {
		// TODO Auto-generated method stub
		return "Falling";
	}

}
