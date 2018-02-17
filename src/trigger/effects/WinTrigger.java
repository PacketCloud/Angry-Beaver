package trigger.effects;

import entities.AbstractEntity;
import trigger.AbstractTrigger;
import trigger.Trigger;

/**
 * Class WinTrigger is a Trigger where the Level 
 * will change to GameStateWin if Entity1 is the id provided   
 */
public class WinTrigger extends AbstractTrigger {
	protected String winID;
	
	public WinTrigger(Trigger nextTrigger, String id) {
		super(nextTrigger);
		this.winID = id;
	}

	@Override
	public void triggerEffects(AbstractEntity entity1, AbstractEntity entity2) {
		super.triggerEffects(entity1, entity2);
		
		if(entity1.getId().equals(winID)) {
			entity1.getLevel().setWin(true);
		}
	}
}
