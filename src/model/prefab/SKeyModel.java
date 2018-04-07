package model.prefab;

import model.AbstractModel;
import resourceHandling.Resource;

public class SKeyModel extends AbstractModel {

	public SKeyModel() {
		super("S Key");
		initialize();
	}

	private void initialize() {
		add(new Resource("S Key", "/Resources/Sprites/Misc/S.gif", (float) 2.5, null, true, "Default"));
		add(new Resource("S Key", "/Resources/Sprites/Misc/S.gif", (float) 2.5, null, true, "NoEntityState"));
	}
}
