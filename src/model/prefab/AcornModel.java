package model.prefab;

import hitbox.Hitbox;
import model.AbstractModel;
import resourceHandling.Resource;

public class AcornModel extends AbstractModel {

	public AcornModel() {
		super("Acorn");
		initialize();	
	}

	public void initialize() {
		// Add new resources
		// Add hitboxes
		add(new Resource("Acorn", "/Resources/Sprites/Entities/Acorn.gif", (float) 2.5, null, true, "Default"));
		add(new Resource("Acorn", "/Resources/Sprites/Entities/Acorn.gif", (float) 2.5, null, true, "NoEntityState"));
		
		Hitbox acornh1 = new Hitbox(1, 1, 12, 12);
		acornh1.setTrigger(true);
		acornh1.setBody(true);
		add(acornh1);
	}	
}
