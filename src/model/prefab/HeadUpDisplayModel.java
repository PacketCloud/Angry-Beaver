package model.prefab;

import model.AbstractModel;
import resourceHandling.Resource;

public class HeadUpDisplayModel extends AbstractModel {

	public HeadUpDisplayModel() {
		super("HeadUpDisplay");
		initialize();
	}

	public void initialize() {
		add(new Resource("HUD Hearts", "/Resources/", (float) 2.5, null, true, "Heart"));
		add(new Resource("HUD Hearts", "/Resources/", (float) 2.5, null, true, "Heart"));		
	}
}
