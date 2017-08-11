package trigger;

import entities.AbstractEntity;

/*
 * AbstractTrigger holds a Trigger component to add extra trigger effects
 */
public abstract class AbstractTrigger implements Trigger {
	protected Trigger nextTrigger;
	
	
	public AbstractTrigger(Trigger nextTrigger) {
		this.nextTrigger = nextTrigger;
	}

	@Override
	public void triggerEffects(AbstractEntity entity1, AbstractEntity entity2) {
		nextTrigger.triggerEffects(entity1, entity2);
	}
}
