package model.prefab;

import hitbox.Hitbox;
import model.AbstractModel;
import resourceHandling.Resource;

public class LogModel extends AbstractModel {

	public LogModel() {
		super("Log");
		initialize();
	}
	
	public void initialize() {
		add(new Resource("Log", "/Resources/Sprites/Entities/Log.gif", (float) 2.5, null, true, "Default"));
		add(new Resource("Log", "/Resources/Sprites/Entities/Log.gif", (float) 2.5, null, true, "NoEntityState"));
		
		Hitbox Logh1 = new Hitbox(1, 1, 20, 13);
		Logh1.setSolid(true);
		Logh1.setBody(true);
		add(Logh1);
	}
}
