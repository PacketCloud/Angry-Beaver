package trigger;

import entities.AbstractEntity;

/**
 * Class AbstractTrigger is the abstract class for all Triggers.
 * Trigger classes hold a Trigger component to add additional trigger effects.
 * 
 * AbstractTrigger uses a Decorator pattern.
 */
public abstract class AbstractTrigger implements Trigger {
	protected Trigger nextTrigger;
	
	public AbstractTrigger(Trigger nextTrigger) {
		this.nextTrigger = nextTrigger;
	}

	/**
	 * Method triggerEffects is used when entity1 triggers entity2 by a 
	 * body Hitbox intersecting a trigger Hitbox. 
	 */
	@Override
	public void triggerEffects(AbstractEntity entity1, AbstractEntity entity2) {
		nextTrigger.triggerEffects(entity1, entity2);
	}
}
