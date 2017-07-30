package states.entityState.basicEntityStates;

import entities.AbstractEntity;

import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

public class BasicEntityStateAttack extends EntityStateAbstract {
	long startTime;
	
	AbstractEntity claw;
	public BasicEntityStateAttack(EntityStateContext context) {
		super(context);
		
		// Currently testing
		startTime = System.nanoTime() / 1000000;
		claw = context.makeEntity();
		context.getEntity().getLevel().addEntity(claw);
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
	public void checkForNextState() {
		// TODO Auto-generated method stub
		
		long endTime = System.nanoTime() / 1000000 - startTime;
		// The duration of Beaver_Claw.gif is 1000 milliseconds
		if(endTime > 1000){
			claw.destroy();
			context.setEntityState(new BasicEntityStateIdle(context));
		}
	}

	@Override
	public String stateToString() {
		// TODO Auto-generated method stub
		return "Attack1";
	}

}
