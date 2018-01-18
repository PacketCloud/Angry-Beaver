package trigger;

import entities.AbstractEntity;

/**
 * Interface Trigger defines required methods for all Triggers
 */
public interface Trigger {
	public void triggerEffects(AbstractEntity entity1, AbstractEntity entity2);
}
