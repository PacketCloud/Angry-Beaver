package behaviour;

import entities.AbstractEntity;
import keyInputs.ACTIONS;

public abstract class AbstractBehaviour implements BehaviourInterface {	
	private int detectionDistance;

	public AbstractBehaviour() {
		this.detectionDistance = 400;
	}

	@Override
	public void doAction(String action, AbstractEntity entity) {
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

	public int getDetectionDistance() {
		return detectionDistance;
	}

	public void setDetectionDistance(int detectionDistance) {
		this.detectionDistance = detectionDistance;
	}

}
