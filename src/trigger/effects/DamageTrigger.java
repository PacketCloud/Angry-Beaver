package trigger.effects;

import entities.AbstractEntity;
import trigger.AbstractTrigger;
import trigger.Trigger;

/*
 * Used for if Entity2 will Damage Entity1
 */
public class DamageTrigger extends AbstractTrigger {

	public DamageTrigger(Trigger nextTrigger) {
		super(nextTrigger);
	}

	@Override
	public void triggerEffects(AbstractEntity entity1, AbstractEntity entity2) {
		// TODO Auto-generated method stub
		super.triggerEffects(entity1, entity2);
		
		// If entity2 is not a sub-entity of entity1
		if(!entity1.getEntities().contains(entity2)) {
			if(!entity1.isInvulnerable()) {
				// Entity1 is damaged by Entity2
				entity1.setHealth(entity1.getHealth() - entity2.getDamage());

				// TODO: Handle Attack Cooldowns?
			}
		}
	}
}
