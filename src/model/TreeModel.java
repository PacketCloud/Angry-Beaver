package model;

import hitbox.Hitbox;
import resourceHandling.Resource;

public class TreeModel extends AbstractModel {

	public TreeModel() {
		super("Tree");
		initialize();
	}

	public void initialize() {
		add(new Resource("Tree", "/Resources/Sprites/Entities/Tree.png", (float) 2.5, null, true, "Default"));
		add(new Resource("Tree", "/Resources/Sprites/Entities/Tree.png", (float) 2.5, null, true, "NoEntityState"));

		add(new Hitbox(0, 0, 35, 21));
		Hitbox treeh1 = new Hitbox(11, 21, 9, 42);
		treeh1.setBody(true);
		add(treeh1);
	}
}
