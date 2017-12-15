package model;

import hitbox.Hitbox;
import resourceHandling.Resource;
import resourceHandling.ResourceCollection;

public class ClawModel extends AbstractModel {

	public ClawModel() {
		super("Claw");
		initialize();
	}
	
	public void initialize() {
		add(new Resource("Claw", "/Resources/Sprites/Entities/Beaver_Claw.gif", (float) 2.5, null, true, "NoEntityState"));
		
		Hitbox clawh1 = new Hitbox(2, 2, 12, 24);
		clawh1.setTrigger(true);
		add(clawh1);
	}
}
