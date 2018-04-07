package trigger.effects;

import entities.AbstractEntity;
import trigger.Trigger;

/**
 * Class SimpleTrigger is a Trigger that does nothing.
 */
public class SimpleTrigger implements Trigger {
	@Override
	public void triggerEffects(AbstractEntity entity1, AbstractEntity entity2) {
		// entity1 triggers entity2
	}
}
