package states.entityState.basicEntityStates;

import java.awt.Point;

import entities.AbstractEntity;

import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

/**
 * Class BasicEntityStateAttack is a generalized Entity State for
 * entities which are in an attacking action.
 *
 * The duration of the attack state is limited by a timer.
 */
public class BasicEntityStateAttack extends EntityStateAbstract {
	private long startTime;
	private AbstractEntity attackEntity;
	
	
	public BasicEntityStateAttack(EntityStateContext context) {
		super(context);
		
		// Set timer to limit the attack state
		startTime = System.nanoTime() / 1000000;
		attackEntity = context.makeEntity(stateToString());
		
		// If an entity is to be created when attacking
		if(attackEntity != null) {
			context.addSubEntity(attackEntity);
			context.getEntity().getLevel().addEntity(attackEntity);
		}
	}

	@Override
	public void right() {
		super.right();
		int x = context.getEntity().getMoveSpeedX();
		context.translate(x, 0);
		context.getEntity().setFacingRight(true);
	}
	
	@Override
	public void left() {
		super.left();
		int x = context.getEntity().getMoveSpeedX();
		context.translate(-x, 0);
		context.getEntity().setFacingRight(false);
	}

	@Override
	public void checkForNextState() {		
		long endTime = System.nanoTime() / 1000000 - startTime;
		if(endTime > 1000){
			if(attackEntity != null) {
				// Remove the attack entity as a sub-entity and as an entity in the level
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
		return "Attack1";
	}

}
