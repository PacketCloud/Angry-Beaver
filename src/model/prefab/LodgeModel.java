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
		
		add(new Resource("Empty", "/Resources/Sprites/Entities/Empty_Image.gif", (float) 2.5, null, true, "Default"));
		add(new Resource("Empty", "/Resources/Sprites/Entities/Empty_Image.gif", (float) 2.5, null, true, "NoEntityState"));
		
		Hitbox lodgeHitbox = new Hitbox(0,0, 40, 40);
		lodgeHitbox.setBody(true);
		lodgeHitbox.setTrigger(true);
		add(lodgeHitbox);
	}

}
