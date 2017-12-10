package model;

import resourceHandling.Resource;

public class UppercutModel extends AbstractModel {

	public UppercutModel() {
		super("Uppercut");
		initialize();
	}

	public void initialize() {
		add(new Resource("Uppercut", "/Resources/Sprites/Entities/Deer_Uppercut.gif", (float) 2.5, null, true, "NoEntityState"));
	}
}
