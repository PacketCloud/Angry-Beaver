package model;

import resourceHandling.Resource;
import resourceHandling.ResourceCollection;

public class TreeModel extends ResourceCollection {

	public TreeModel() {
		super("Tree");
		initialize();
	}

	public void initialize() {
		add(new Resource("Tree", "/Resources/Sprites/Entities/Tree.png", (float) 2.5, null, true, "NoEntityState"));
	}
}
