package behaviour;

import entities.AbstractEntity;
import keyInputs.ACTIONS;
//Will be used in entity (or state) to call correct behaviour methods depending on entity type

public abstract class AbstractBehaviour implements BehaviourInterface {

	public AbstractBehaviour () {}

	@Override
	public void behaviour(String action, AbstractEntity entity) {
		// TODO Auto-generated method stub
		switch (action) {
		case ACTIONS.MOVE_UP:
			entity.up();
			break;
		case ACTIONS.MOVE_DOWN:
			entity.down();
			break;
		case ACTIONS.MOVE_RIGHT:
			entity.right();
			break;
		case ACTIONS.MOVE_LEFT:
			entity.left();
			break;
		case ACTIONS.JUMP:
			entity.jump();
			break;
		case ACTIONS.ATTACK:
			entity.attack();
			break;
		case ACTIONS.ATTACK2:
			entity.attack2();
			break;
		}
	}

}
