package model.prefab;

import model.AbstractModel;
import resourceHandling.Resource;

public class LeftArrowModel extends AbstractModel {

	public LeftArrowModel() {
		super("Left Arrow");
		initialize();
	}

	private void initialize() {
		add(new Resource("Left Arrow", "/Resources/Sprites/Misc/Left.gif", (float) 2.5, null, true, "Default"));
		add(new Resource("Left Arrow", "/Resources/Sprites/Misc/Left.gif", (float) 2.5, null, true, "NoEntityState"));
	}
}
