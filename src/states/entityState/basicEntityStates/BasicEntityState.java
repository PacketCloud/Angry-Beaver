package states.entityState.basicEntityStates;

import java.awt.Graphics2D;

import entities.AbstractEntity;
import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

public class BasicEntityState extends EntityStateAbstract {

	public BasicEntityState(EntityStateContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics2D g, AbstractEntity entity) {
		// TODO Auto-generated method stub
		super.render(g, entity);
	}

	@Override
	public void up(AbstractEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void down(AbstractEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void right(AbstractEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void left(AbstractEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause(AbstractEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jump(AbstractEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(AbstractEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack2(AbstractEntity entity) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "Walking";
	}
}
