package trigger;

import trigger.effects.DamageTrigger;
import trigger.effects.KnockbackTrigger;
import trigger.effects.SimpleTrigger;


/*
 * TriggerFactory creates a Trigger Decorator by recursively parsing a given String
 * 
 *   Ex. Given "Damage Damage", TriggerFactory will return a Trigger
 *   	equivalent to: new DamageTrigger( new DamageTrigger( new SimpleTrigger() ) )
 */
public class TriggerFactory {

	public Trigger createTrigger(String triggers) {
		String[] split = triggers.split(" ", 2);
		
		Trigger holder = new SimpleTrigger();
		if(split.length == 2) {
			 holder = createTrigger(split[1]);
		}
		
		// TODO: As more Trigger effects are created, add them here
		/*
		switch(split[0]) {
		case "Damage":
			return new DamageTrigger(holder);
		case "KnockBack":
			return new KnockbackTrigger(holder);
		default:
			return new SimpleTrigger();
		}
		*/
		
		if(split[0].startsWith("Damage")) {
			return new DamageTrigger(holder);
			
		} else if(split[0].startsWith("KnockBack")) {
			// TODO: Error handling
			// The String input must be in a format of "KnockBack:xForce:yForce:duration"
			String[] parse = split[0].split(":",4);
			return new KnockbackTrigger(holder, Integer.parseInt(parse[1]), Integer.parseInt(parse[2]), Integer.parseInt(parse[3]));
			
		} else {
			return new SimpleTrigger();
		}
	}
}
