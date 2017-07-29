package states.entityState.basicEntityStates;

import java.awt.Point;

import entities.BasicEntity;
import hitbox.Hitbox;
import resourceHandling.Resource;
import resourceHandling.ResourceCollection;
import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

public class BasicEntityStateAttack extends EntityStateAbstract {

	public BasicEntityStateAttack(EntityStateContext context) {
		super(context);
		
		// Currently testing
		
		ResourceCollection ClawResourceCollection = new ResourceCollection("Claw");
		ClawResourceCollection.add(new Resource("Claw", "/Resources/Sprites/Entities/Beaver_Claw.gif", (float) 2.5, null, true, "Idle"));
		BasicEntity claw = new BasicEntity(ClawResourceCollection);
		claw.setPosition(new Point(100, 100)); // Set relative to the beaver
		Hitbox clawh1 = new Hitbox(2, 2, 12, 23);
		clawh1.setTrigger(true);
		claw.addHitbox(clawh1);
		claw.setStatic(true);
		claw.setScaling(context.getScaling());
		claw.setFacingRight(context.isFacingRight());
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
	}

	@Override
	public String stateToString() {
		// TODO Auto-generated method stub
		return "Attack1";
	}

}
