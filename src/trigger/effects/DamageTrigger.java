package trigger.effects;

import java.util.HashMap;
import java.util.Map;

import entities.AbstractEntity;
import trigger.AbstractTrigger;
import trigger.Trigger;

/**
 * Class DamageTrigger is a Trigger where Entity2 will reduce the health of Entity1.
 */
public class DamageTrigger extends AbstractTrigger {
	protected Map<AbstractEntity, AbstractEntity> previousHits;
	protected int damageValue;
	
	public DamageTrigger(Trigger nextTrigger, int damageValue) {
		super(nextTrigger);
		previousHits = new HashMap<AbstractEntity, AbstractEntity>();
		this.damageValue = damageValue;
	}

	@Override
	public void triggerEffects(AbstractEntity entity1, AbstractEntity entity2) {
		super.triggerEffects(entity1, entity2);
		
		// If entity2 is not a sub-entity of entity1 and this hit has not happened yet
		if(!entity1.getEntities().contains(entity2) && previousHits.get(entity1) != entity2) {
			if(!entity1.isInvulnerable()) {
				// Entity1 is damaged by Entity2
				entity1.subHealth(damageValue);
				previousHits.put(entity1, entity2);
				// TODO: Handle Attack Cooldowns?
			}
		}
	}
}
