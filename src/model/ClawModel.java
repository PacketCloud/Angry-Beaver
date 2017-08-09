package model;

import resourceHandling.Resource;
import resourceHandling.ResourceCollection;

public class ClawModel extends ResourceCollection {

	public ClawModel() {
		super("Claw");
		initialize();
	}
	
	public void initialize() {
		add(new Resource("Claw", "/Resources/Sprites/Entities/Beaver_Claw.gif", (float) 2.5, null, true, "Idle"));
	}
}
