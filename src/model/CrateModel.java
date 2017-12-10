package model;

import hitbox.Hitbox;
import resourceHandling.Resource;
import resourceHandling.ResourceCollection;

public class CrateModel extends AbstractModel {

	public CrateModel() {
		super("Crate");
		initialize();
	}
	
	public void initialize() {
		add(new Resource("Crate", "/Resources/Sprites/Entities/Wooden Crate.gif", (float) 2.5, null, true, "Default"));
		add(new Resource("Crate", "/Resources/Sprites/Entities/Wooden Crate.gif", (float) 2.5, null, true, "NoEntityState"));
		
		Hitbox crateh1 = new Hitbox(2, 2, 15, 15);
		crateh1.setSolid(true);
		crateh1.setBody(true);
		add(crateh1);
	}
}
