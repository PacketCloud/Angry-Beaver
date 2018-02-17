package trigger;

import trigger.effects.*;

/**
 * Class TriggerFactory is used to create a Trigger Decorator by recursively parsing a given String.
 * 
 * Ex. Given "Damage,1|Damage,1", TriggerFactory will return a Trigger
 *  equivalent to: new DamageTrigger( new DamageTrigger( new SimpleTrigger(), 1 ), 1)
 *  An entity which triggers this trigger will be damaged for 2 health.
 */
public class TriggerFactory {

	public Trigger createTrigger(String triggers) {
		String[] split = triggers.split("\\|", 2);
		System.out.print(split[0]);
		Trigger holder = new SimpleTrigger();
		if(split.length == 2) {
			 holder = createTrigger(split[1]);
		}
		
		// TODO: As more Trigger effects are created, add them here
		if(split[0].startsWith("Damage")) {
			// TODO: Error handling
			// The String input must be in a format of "Damage,damage_value"
			String[] parse = split[0].split(",",2);
			return new DamageTrigger(holder, Integer.parseInt(parse[1]));
		} else if(split[0].startsWith("Health")) {
			// TODO: Error handling
			// The String input must be in a format of "KnockBack,heal_value"
			String[] parse = split[0].split(",",2);
			return new HealthTrigger(holder, Integer.parseInt(parse[1]));
			
		} else if(split[0].startsWith("KnockBack")) {
			// TODO: Error handling
			// The String input must be in a format of "KnockBack,xForce,yForce,duration"
			String[] parse = split[0].split(",",4);
			return new KnockbackTrigger(holder, Integer.parseInt(parse[1]), Integer.parseInt(parse[2]), Integer.parseInt(parse[3]));
			
		} else if(split[0].startsWith("Win")) {
			// TODO: Error handling
			// The String input must be in a format of "Win,Id_for_winning"
			String[] parse = split[0].split(",",2);
			return new WinTrigger(holder, parse[1]);
			
		} else {
			return new SimpleTrigger();
		}
	}
}
