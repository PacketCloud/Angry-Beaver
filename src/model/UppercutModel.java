package model;

import resourceHandling.Resource;
import resourceHandling.ResourceCollection;

public class UppercutModel extends ResourceCollection {

	public UppercutModel() {
		super("Uppercut");
		initialize();
	}

	public void initialize() {
		add(new Resource("Uppercut", "/Resources/Sprites/Entities/Deer_Uppercut.gif", (float) 2.5, null, true, "NoEntityState"));
	}
}
