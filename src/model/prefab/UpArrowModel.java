package model.prefab;

import model.AbstractModel;
import resourceHandling.Resource;

public class UpArrowModel extends AbstractModel {

	public UpArrowModel() {
		super("Up Arrow");
		initialize();
	}

	private void initialize() {
		add(new Resource("Up Arrow", "/Resources/Sprites/Misc/Up.gif", (float) 2.5, null, true, "Default"));
		add(new Resource("Up Arrow", "/Resources/Sprites/Misc/Up.gif", (float) 2.5, null, true, "NoEntityState"));
	}
}
