package entities.prefab;

import entities.AbstractEntity;
import model.AbstractModel;
import trigger.TriggerFactory;

public class Claw extends AbstractEntity {

	public Claw(AbstractModel model) {
		super(model, "Basic Null Entity");
		// TODO Auto-generated constructor stub
		
		setTrigger(new TriggerFactory().createTrigger("Damage|KnockBack,-5,-2,250"));
		setStatic(true);
	}
}
