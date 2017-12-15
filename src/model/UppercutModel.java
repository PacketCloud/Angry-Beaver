package model;

import hitbox.Hitbox;
import resourceHandling.Resource;

public class UppercutModel extends AbstractModel {

	public UppercutModel() {
		super("Uppercut");
		initialize();
	}

	public void initialize() {
		add(new Resource("Uppercut", "/Resources/Sprites/Entities/Deer_Uppercut.gif", (float) 2.5, null, true, "NoEntityState"));
		
		Hitbox clawh1 = new Hitbox(4, 3, 17, 44);
		clawh1.setTrigger(true);
		add(clawh1);
	}
}
