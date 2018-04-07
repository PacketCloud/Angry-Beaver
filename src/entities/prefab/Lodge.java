package entities.prefab;

import entities.AbstractEntity;
import model.prefab.LodgeModel;
import states.entityState.EntityStateContext;

public class Lodge extends AbstractEntity {

	public Lodge() {
		super();
		setModel(new LodgeModel());
		setInvulnerable(true);
		setState(new EntityStateContext(this, "Lodge_State_1"));
	}
	
}
