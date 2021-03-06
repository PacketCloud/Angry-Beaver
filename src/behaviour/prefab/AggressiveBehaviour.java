package behaviour.prefab;

import java.awt.Point;

import behaviour.AbstractBehaviour;
import engine.Level;
import entities.AbstractEntity;
import keyInputs.ACTIONS;

/**
 * Class AggressiveBehaviour defines an aggressive behaviour
 * toward the Player.
 * 
 * An entity with the Aggressive behaviour will run toward the
 * player and attack when the player is within a certain range.
 */

public class AggressiveBehaviour extends AbstractBehaviour {

	@Override
	public void run(AbstractEntity entity, Level level) {
		// Find player in level 
		AbstractEntity player = level.findByID("Player");
		if (player == null) {
			return;
		}
		
		// Find distance to the player by using Pythagorean Theorem
		Point p = player.getPosition();
		double xDistance = p.getX() - entity.getPosition().getX();
		double yDistance = p.getY() - entity.getPosition().getY();
		double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
		
		// Check if within detection
		if (distance < getDetectionDistance()) {
			if (distance > getDetectionDistance() / 4) {
				if (xDistance <= 0) {
					// Move left if Player is to the left
					doAction(ACTIONS.MOVE_LEFT, entity);
				} else {
					// Move right if Player is to the right
					doAction(ACTIONS.MOVE_RIGHT, entity);
				}
			} else {
				// Attack if close enough to Player
				doAction(ACTIONS.ATTACK, entity);
			}
		}
	}
}
