package trigger.effects;

import java.util.HashMap;
import java.util.Map;

import entities.AbstractEntity;
import trigger.AbstractTrigger;
import trigger.Trigger;

/*
 * Used for if Entity2 will Damage Entity1
 */
public class DamageTrigger extends AbstractTrigger {
	protected Map<AbstractEntity, AbstractEntity> previousHits;
	
	
	public DamageTrigger(Trigger nextTrigger) {
		super(nextTrigger);
		previousHits = new HashMap<AbstractEntity, AbstractEntity>();
	}

	@Override
	public void triggerEffects(AbstractEntity entity1, AbstractEntity entity2) {
		// TODO Auto-generated method stub
		super.triggerEffects(entity1, entity2);
		
		// If entity2 is not a sub-entity of entity1 and this hit has not happened yet
		if(!entity1.getEntities().contains(entity2) && previousHits.get(entity1) != entity2) {
			if(!entity1.isInvulnerable()) {
				// Entity1 is damaged by Entity2
				entity1.setHealth(entity1.getHealth() - entity2.getDamage());
				previousHits.put(entity1, entity2);
				// TODO: Handle Attack Cooldowns?
			}
		}
	}
}
