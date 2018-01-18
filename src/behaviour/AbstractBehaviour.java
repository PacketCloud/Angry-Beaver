package behaviour;

import entities.AbstractEntity;
import keyInputs.ACTIONS;

/**
 * Class AbstractBehaviour is the abstract class for behaviours.
 * 
 * A behaviour will determine how an entity will act.
 */

public abstract class AbstractBehaviour implements BehaviourInterface {	
	private int detectionDistance;

	public AbstractBehaviour() {
		this.detectionDistance = 400;
	}

	/**
	 * Method doAction takes a given action String and performs that action
	 * on a given entity.
	 * 
	 * @param action    A String of what action the entity should be performed.
	 * 					These Strings are defined in the ACTIONS class
	 * @param entity	The entity which the action is performed on.
	 */
	@Override
	public void doAction(String action, AbstractEntity entity) {
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

	/******** Getters and Setters ********/
	
	public int getDetectionDistance() {
		return detectionDistance;
	}

	public void setDetectionDistance(int detectionDistance) {
		this.detectionDistance = detectionDistance;
	}

}
