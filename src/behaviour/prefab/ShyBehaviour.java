package behaviour.prefab;

import java.awt.Point;

import behaviour.AbstractBehaviour;
import engine.Level;
import entities.AbstractEntity;
import keyInputs.ACTIONS;

/**
 * Class ShyBehaviour defines a sky behaviour toward
 * the Player.
 * 
 * An entity with the Shy behaviour will run away from the
 * player when the player is within a certain range.
 */

public class ShyBehaviour extends AbstractBehaviour {

	@Override
	public void run(AbstractEntity entity, Level level) {
		// Find Player in level
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
			if(xDistance <= 0) {
				// Move right if Player is to the left
				doAction(ACTIONS.MOVE_RIGHT, entity);
			} else {
				// Move left if Player is to the right
				doAction(ACTIONS.MOVE_LEFT, entity);
			}
		}
	}

}
