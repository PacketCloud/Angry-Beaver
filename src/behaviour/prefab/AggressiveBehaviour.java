package behaviour.prefab;

import java.awt.Point;

import behaviour.AbstractBehaviour;
import engine.Level;
import entities.AbstractEntity;
import keyInputs.ACTIONS;

/*
 * An entity with the Aggressive behaviour will run toward the
 * player and attack when the player is within a certain range.
 */

public class AggressiveBehaviour extends AbstractBehaviour {

	@Override
	public void run(AbstractEntity entity, Level level) {
		AbstractEntity player = level.findByID("Player");
		if (player == null) {
			return;
		}
		
		Point p = player.getPosition();
		double xDistance = p.getX() - entity.getPosition().getX();
		double yDistance = p.getY() - entity.getPosition().getY();
		double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
		
		if (distance < getDetectionDistance()) {
			if (distance > getDetectionDistance() / 4) {
				if (xDistance <= 0) {
					doAction(ACTIONS.MOVE_LEFT, entity);
				} else {
					doAction(ACTIONS.MOVE_RIGHT, entity);
				}
			} else {
				doAction(ACTIONS.ATTACK, entity);
			}
		}
	}

}
