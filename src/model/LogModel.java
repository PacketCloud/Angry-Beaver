package model;

import resourceHandling.Resource;
import resourceHandling.ResourceCollection;

public class LogModel extends ResourceCollection {

	public LogModel() {
		super("Log");
		initialize();
	}
	
	public void initialize() {
		add(new Resource("Log", "/Resources/Sprites/Entities/Log.gif", (float) 2.5, null, true, "Default"));
		add(new Resource("Log", "/Resources/Sprites/Entities/Log.gif", (float) 2.5, null, true, "NoEntityState"));
	}
}
