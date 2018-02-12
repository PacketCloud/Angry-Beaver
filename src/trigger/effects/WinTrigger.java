package trigger.effects;

import entities.AbstractEntity;
import trigger.AbstractTrigger;
import trigger.Trigger;

/**
 * Class WinTrigger is a Trigger where the Level 
 * will change to GameStateWin if Entity2 is the Player   
 */
public class WinTrigger extends AbstractTrigger {

	public WinTrigger(Trigger nextTrigger) {
		super(nextTrigger);
	}

	@Override
	public void triggerEffects(AbstractEntity entity1, AbstractEntity entity2) {
		super.triggerEffects(entity1, entity2);
		
		if(entity2.getId().equals("Player")) {
			entity1.getLevel().setWin(true);
		}
	}
}
