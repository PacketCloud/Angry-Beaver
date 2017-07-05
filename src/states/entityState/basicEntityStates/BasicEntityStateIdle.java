package states.entityState.basicEntityStates;

import java.awt.Graphics2D;

import entities.AbstractEntity;
import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

public class BasicEntityStateIdle extends EntityStateAbstract {

	public BasicEntityStateIdle(EntityStateContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void right(AbstractEntity entity) {
		// TODO Auto-generated method stub
		super.right(entity);
		int x = context.getEntity().getMoveSpeedX();
		context.translate(x, 0);
	}
	
	@Override
	public void left(AbstractEntity entity) {
		// TODO Auto-generated method stub
		super.left(entity);
		int x = context.getEntity().getMoveSpeedX();
		context.translate(-x, 0);
	}	
	
	@Override
	public String stateToString() {
		// TODO Auto-generated method stub
		return "Walking";
	}
}
