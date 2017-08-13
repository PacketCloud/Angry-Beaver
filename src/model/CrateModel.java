package model;

import resourceHandling.Resource;
import resourceHandling.ResourceCollection;

public class CrateModel extends ResourceCollection {

	public CrateModel() {
		super("Crate");
		initialize();
	}
	
	public void initialize() {
		add(new Resource("Crate", "/Resources/Sprites/Entities/Wooden Crate.gif", (float) 2.5, null, true, "Default"));
		add(new Resource("Crate", "/Resources/Sprites/Entities/Wooden Crate.gif", (float) 2.5, null, true, "NoEntityState"));
	}
}
