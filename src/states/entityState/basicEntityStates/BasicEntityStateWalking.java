package states.entityState.basicEntityStates;

import java.awt.Point;

import entities.AbstractEntity;
import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

public class BasicEntityStateWalking extends EntityStateAbstract {

	public BasicEntityStateWalking(EntityStateContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	// Methods Up and Down are temporary for movement
	@Override
	public void up() {
		// TODO Auto-generated method stub
		super.up();
		int y = context.getEntity().getMoveSpeedY();
		context.translate(0, -y);
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		super.down();
		int y = context.getEntity().getMoveSpeedY();
		context.translate(0, y);
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		super.right();
		int x = context.getEntity().getMoveSpeedX();
		context.translate(x, 0);
		context.getEntity().setFacingRight(true);
	}
	
	@Override
	public void left() {
		// TODO Auto-generated method stub
		super.left();
		int x = context.getEntity().getMoveSpeedX();
		context.translate(-x, 0);
		context.getEntity().setFacingRight(false);
	}
	
	@Override
	public String stateToString() {
		// TODO Auto-generated method stub
		return "Walking";
	}

	@Override
	public void checkForNextState() {
		// TODO Auto-generated method stub
		Point curPos = context.getCurrentPosition();
		Point lastPos = context.getLastPosition();
		
		/*
		 * Change state to falling/rising if moving on y axis
		if ((curPos.y - lastPos.y) < 0){
			context.setEntityState(new BasicEntityStateRising(context));
		}
		
		if ((curPos.y - lastPos.y) > 0){
			context.setEntityState(new BasicEntityStateFalling(context));
		}
		*/
		
		
		// Change state to idle if not moving on x axis
		if ((curPos.x - lastPos.x) == 0){
			context.setEntityState(new BasicEntityStateIdle(context));
		}
	}
}
