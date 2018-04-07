package model.prefab;

import model.AbstractModel;
import resourceHandling.Resource;

public class DownArrowModel extends AbstractModel {

	public DownArrowModel() {
		super("Down Arrow");
		initialize();
	}

	private void initialize() {
		add(new Resource("Down Arrow", "/Resources/Sprites/Misc/Down.gif", (float) 2.5, null, true, "Default"));
		add(new Resource("Down Arrow", "/Resources/Sprites/Misc/Down.gif", (float) 2.5, null, true, "NoEntityState"));	
	}
}
