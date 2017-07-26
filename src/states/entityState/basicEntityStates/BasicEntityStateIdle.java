package states.entityState.basicEntityStates;

import java.awt.Point;

import entities.AbstractEntity;
import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

public class BasicEntityStateIdle extends EntityStateAbstract {

	public BasicEntityStateIdle(EntityStateContext context) {
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
		context.setEntityState(new BasicEntityStateWalking(context));
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		super.down();
		int y = context.getEntity().getMoveSpeedY();
		context.translate(0, y);
		context.setEntityState(new BasicEntityStateWalking(context));
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		super.right();
		int x = context.getEntity().getMoveSpeedX();
		context.translate(x, 0);
		context.getEntity().setFacingRight(true);
		context.setEntityState(new BasicEntityStateWalking(context));
	}
	
	@Override
	public void left() {
		// TODO Auto-generated method stub
		super.left();
		int x = context.getEntity().getMoveSpeedX();
		context.translate(-x, 0);
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
		
		/*
		Point curPos = context.getCurrentPosition();
		Point lastPos = context.getLastPosition();
		
		
		Change state to falling/rising if moving on y axis
		if ((curPos.y - lastPos.y) < 0){
			context.setEntityState(new BasicEntityStateRising(context));
		}
		
		if ((curPos.y - lastPos.y) > 0){
			context.setEntityState(new BasicEntityStateFalling(context));
		}
		*/
	}
}
