package entities.prefab;

import entities.AbstractEntity;
import model.prefab.AcornModel;
import trigger.TriggerFactory;

public class Acorn extends AbstractEntity {

	public Acorn() {
		super();
		// TODO Auto-generated constructor stub
		
		setTrigger(new TriggerFactory().createTrigger("Damage,1|KnockBack,-1,-2,250"));
		setModel(new AcornModel());
	}
}
