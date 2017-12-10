package states.entityState.basicEntityStates;

import java.awt.Point;

import entities.AbstractEntity;

import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

public class BasicEntityStateAttack extends EntityStateAbstract {
	long startTime;
	
	AbstractEntity attackEntity;
	public BasicEntityStateAttack(EntityStateContext context) {
		super(context);
		
		// Currently testing
		startTime = System.nanoTime() / 1000000;
		attackEntity = context.makeEntity(stateToString());
		
		if(attackEntity != null) {
			// Add claw as a sub-entity and as an entity in the level
			context.addSubEntity(attackEntity);
			context.getEntity().getLevel().addEntity(attackEntity);
		}
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
			if(attackEntity != null) {
				// Remove claw as a sub-entity and as an entity in the level
				context.removeSubEntity(attackEntity);
				attackEntity.destroy();
				
				// Temporary solution to restarting an attack animation which only loops once
				context.getEntity().getModel().getImageIcon(stateToString()).flush();
			}
			
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
			
			if (context.getHealth() <= 0) {
				context.setEntityState(new BasicEntityStateDying(context));
			}
		}
	}

	@Override
	public String stateToString() {
		// TODO Auto-generated method stub
		return "Attack1";
	}

}
