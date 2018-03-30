package model.prefab;

import hitbox.Hitbox;
import model.AbstractModel;
import resourceHandling.Resource;

public class LodgeModel extends AbstractModel {

	public LodgeModel() {
		super("Lodge");
		initialize();
	}
	
	public void initialize() {
		add(new Resource("Empty", "/Resources/Sprites/Entities/Lodge_Complete.png", (float) 2.5, null, true, "Lodge_Complete"));
		add(new Resource("Empty", "/Resources/Sprites/Entities/Lodge_Incomplete.png", (float) 2.5, null, true, "Lodge_Incomplete"));
		add(new Resource("Empty", "/Resources/Sprites/Entities/Empty_Image.gif", (float) 2.5, null, true, "Default"));
		add(new Resource("Empty", "/Resources/Sprites/Entities/Empty_Image.gif", (float) 2.5, null, true, "NoEntityState"));
		
		Hitbox lodgeHitbox = new Hitbox(9, 4, 23, 11);
		lodgeHitbox.setBody(true);
		lodgeHitbox.setTrigger(true);
		add(lodgeHitbox);
	}

}
