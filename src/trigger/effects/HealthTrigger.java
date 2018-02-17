package trigger.effects;

import java.util.HashMap;
import java.util.Map;

import entities.AbstractEntity;
import trigger.AbstractTrigger;
import trigger.Trigger;

public class HealthTrigger extends AbstractTrigger {
	protected Map<AbstractEntity, AbstractEntity> previousHits;
	protected int healValue;
	
	public HealthTrigger(Trigger nextTrigger, int healValue) {
		super(nextTrigger);
		previousHits = new HashMap<AbstractEntity, AbstractEntity>();
		this.healValue = healValue;
	}

	@Override
	public void triggerEffects(AbstractEntity entity1, AbstractEntity entity2) {
		super.triggerEffects(entity1, entity2);
		
		// If entity2 is not a sub-entity of entity1 and this hit has not happened yet
		if(!entity1.getEntities().contains(entity2) && previousHits.get(entity1) != entity2) {
			if(!entity1.isInvulnerable()) {
				// Entity1 is damaged by Entity2
				entity1.setHealth(entity1.getHealth() + healValue);
				previousHits.put(entity1, entity2);
			}
		}
	}
}
