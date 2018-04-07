package trigger.effects;

import java.util.HashMap;
import java.util.Map;

import entities.AbstractEntity;
import force.TimedForce;
import trigger.AbstractTrigger;
import trigger.Trigger;

/**
 * Class KnockbackTrigger is a Trigger where Entity2 will apply a force on Entity1.
 */
public class KnockbackTrigger extends AbstractTrigger {
	protected Map<AbstractEntity, AbstractEntity> previousHits;
	int xForce;
	int yForce;
	int duration;
	
	public KnockbackTrigger(Trigger nextTrigger, int xForce, int yForce, int duration) {
		super(nextTrigger);
		previousHits = new HashMap<AbstractEntity, AbstractEntity>();
		this.xForce = xForce;
		this.yForce = yForce;
		this.duration = duration;
	}

	@Override
	public void triggerEffects(AbstractEntity entity1, AbstractEntity entity2) {
		// TODO Auto-generated method stub
		super.triggerEffects(entity1, entity2);
		
		// Example of a knockback effect for an attack
		// TODO: Allow TriggerFactory to dynamically create different forces of knockback
		if(!entity1.getEntities().contains(entity2) && previousHits.get(entity1) != entity2) {
			if(!entity1.isInvulnerable()) {
				entity1.addForce(new TimedForce(xForce * entity2.facing(), yForce, duration));
				previousHits.put(entity1, entity2);
			}
		}
	}
}
