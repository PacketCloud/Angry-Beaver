package entities.prefab;

import entities.AbstractEntity;
import model.AbstractModel;
import model.UppercutModel;
import trigger.TriggerFactory;

public class Uppercut extends AbstractEntity {

	public Uppercut(AbstractModel model) {
		super();
		// TODO Auto-generated constructor stub
		
		setTrigger(new TriggerFactory().createTrigger("Damage|KnockBack,-2,-10,250"));
		setStatic(true);
		setModel(new UppercutModel());
	}

}
