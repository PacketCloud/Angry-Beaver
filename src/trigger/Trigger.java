package trigger;

import entities.AbstractEntity;

// entity1 triggers entity2
public interface Trigger {
	public void triggerEffects(AbstractEntity entity1, AbstractEntity entity2);
}
