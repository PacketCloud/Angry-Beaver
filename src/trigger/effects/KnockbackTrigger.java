package trigger.effects;

import java.util.HashMap;
import java.util.Map;

import entities.AbstractEntity;
import force.TimedForce;
import trigger.AbstractTrigger;
import trigger.Trigger;

public class KnockbackTrigger extends AbstractTrigger {
	protected Map<AbstractEntity, AbstractEntity> previousHits;
	
	public KnockbackTrigger(Trigger nextTrigger) {
		super(nextTrigger);
		previousHits = new HashMap<AbstractEntity, AbstractEntity>();
	}

	@Override
	public void triggerEffects(AbstractEntity entity1, AbstractEntity entity2) {
		// TODO Auto-generated method stub
		super.triggerEffects(entity1, entity2);
		
		// Example of a knockback effect for an attack
		// TODO: Allow TriggerFactory to dynamically create different forces of knockback
		if(!entity1.getEntities().contains(entity2) && previousHits.get(entity1) != entity2) {
			entity1.addForce(new TimedForce(-5 * entity2.facing(), -2, 250));
			previousHits.put(entity1, entity2);
		}
	}
}
