package entities.prefab;

import entities.AbstractEntity;
import model.prefab.ClawModel;
import trigger.TriggerFactory;

public class Claw extends AbstractEntity {

	public Claw() {
		super();
		// TODO Auto-generated constructor stub
		
		setTrigger(new TriggerFactory().createTrigger("Damage|KnockBack,-5,-2,250"));
		setStatic(true);
		setModel(new ClawModel());
	}
}
