package model.prefab;

import model.AbstractModel;
import resourceHandling.Resource;

public class DKeyModel extends AbstractModel {

	public DKeyModel() {
		super("D Key");
		initialize();
	}

	private void initialize() {
		add(new Resource("D Key", "/Resources/Sprites/Misc/D.gif", (float) 2.5, null, true, "Default"));
		add(new Resource("D Key", "/Resources/Sprites/Misc/D.gif", (float) 2.5, null, true, "NoEntityState"));
	}
}
