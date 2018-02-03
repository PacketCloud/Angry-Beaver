package model.prefab;

import model.AbstractModel;
import resourceHandling.Resource;

public class RightArrowModel extends AbstractModel {

	public RightArrowModel() {
		super("Right Arrow");
		initialize();
	}

	private void initialize() {
		add(new Resource("Right Arrow", "/Resources/Sprites/Misc/Right.gif", (float) 2.5, null, true, "Default"));
		add(new Resource("Right Arrow", "/Resources/Sprites/Misc/Right.gif", (float) 2.5, null, true, "NoEntityState"));
	}
}
