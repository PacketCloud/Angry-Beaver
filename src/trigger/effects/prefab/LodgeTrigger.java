package trigger.effects.prefab;

import entities.AbstractEntity;
import entities.prefab.Log;
import trigger.AbstractTrigger;
import trigger.Trigger;

public class LodgeTrigger extends AbstractTrigger {

	public LodgeTrigger(Trigger nextTrigger) {
		super(nextTrigger);
	}

	@Override
	public void triggerEffects(AbstractEntity entity1, AbstractEntity entity2) {
		super.triggerEffects(entity1, entity2);
		
		if(entity1 instanceof Log) {
			entity2.setHealth(entity2.getHealth() + 1);
			entity1.destroy();
		}
	}
}
