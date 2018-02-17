package entities.prefab;

import entities.AbstractEntity;
import model.prefab.LodgeModel;
import trigger.TriggerFactory;

public class Lodge extends AbstractEntity {

	public Lodge() {
		super();
		setModel(new LodgeModel());
		setInvulnerable(true);
		setTrigger(new TriggerFactory().createTrigger("Win,Player"));
	}
	
}
