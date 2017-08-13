package model;

import resourceHandling.Resource;
import resourceHandling.ResourceCollection;

public class DeerModel extends ResourceCollection {

	public DeerModel() {
		super("Deer");
		initialize();
	}
	
	public void initialize() {
		// TODO: Add other deer resources
		add(new Resource("Deer Idle", "/Resources/Sprites/Mobs/Deer_Idle.gif", (float) 2.5, null, true, "Default"));
		add(new Resource("Deer Idle", "/Resources/Sprites/Mobs/Deer_Idle.gif", (float) 2.5, null, true, "Idle"));
	}
}
