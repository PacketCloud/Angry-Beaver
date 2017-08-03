package states.entityState.basicEntityStates;

import java.awt.Point;

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
		
		// Add claw as a sub-entity and as an entity in the level
		context.addSubEntity(claw);
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
			// Remove claw as a sub-entity and as an entity in the level
			context.removeSubEntity(claw);
			claw.destroy();
			
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
			
			// Change state to falling if moving down on y axis
			if ((curPos.y - lastPos.y) > 0){
				context.setEntityState(new BasicEntityStateFalling(context));
			}
		}
	}

	@Override
	public String stateToString() {
		// TODO Auto-generated method stub
		return "Attack1";
	}

}
