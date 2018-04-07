package model.prefab;

import model.AbstractModel;
import resourceHandling.Resource;

public class EmptyModel extends AbstractModel {

	public EmptyModel() {
		super("Empty");
		initialize();
	}

	public void initialize() {
		add(new Resource("Empty", "/Resources/Sprites/Entities/Empty_Image.gif", (float) 2.5, null, true, "Default"));
		add(new Resource("Empty", "/Resources/Sprites/Entities/Empty_Image.gif", (float) 2.5, null, true, "NoEntityState"));
	}
}
