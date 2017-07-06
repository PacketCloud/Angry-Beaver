package states.entityState.basicEntityStates;

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
	public void up(AbstractEntity entity) {
		// TODO Auto-generated method stub
		super.up(entity);
		int y = context.getEntity().getMoveSpeedY();
		context.translate(0, -y);
	}

	@Override
	public void down(AbstractEntity entity) {
		// TODO Auto-generated method stub
		super.down(entity);
		int y = context.getEntity().getMoveSpeedY();
		context.translate(0, y);
	}

	@Override
	public void right(AbstractEntity entity) {
		// TODO Auto-generated method stub
		super.right(entity);
		int x = context.getEntity().getMoveSpeedX();
		context.translate(x, 0);
		context.getEntity().setFacingRight(true);
	}
	
	@Override
	public void left(AbstractEntity entity) {
		// TODO Auto-generated method stub
		super.left(entity);
		int x = context.getEntity().getMoveSpeedX();
		context.translate(-x, 0);
		context.getEntity().setFacingRight(false);
	}
	
	@Override
	public String stateToString() {
		// TODO Auto-generated method stub
		return "Walking";
	}

}
