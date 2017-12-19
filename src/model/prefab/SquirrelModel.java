package model.prefab;

import hitbox.Hitbox;
import model.AbstractModel;
import resourceHandling.Resource;

public class SquirrelModel extends AbstractModel {

	public SquirrelModel() {
		super("Squirrel");
		initialize();
	}

	public void initialize() {
		// Add new resources
		// TODO: change resources when Squirrel model is finished
		add(new Resource("Squirrel Default", "/Resources/Sprites/Mobs/Squirrel_Idle.gif", (float) 2.5, null, true, "Default"));
		
		add(new Resource("Squirrel Walking", "/Resources/Sprites/Mobs/Squirrel_Idle.gif", (float) 2.5, null, true, "Walking"));
		add(new Resource("Squirrel Idle", "/Resources/Sprites/Mobs/Squirrel_Idle.gif", (float) 2.5, null, true, "Idle"));
		add(new Resource("Squirrel Falling", "/Resources/Sprites/Mobs/Squirrel_Idle.gif", (float) 2.5, null, true, "Falling"));
		add(new Resource("Squirrel Rising", "/Resources/Sprites/Mobs/Squirrel_Idle.gif", (float) 2.5, null, true, "Rising"));
		add(new Resource("Squirrel Attack", "/Resources/Sprites/Mobs/Squirrel_Idle.gif", (float) 2.5, null, true, "Attack1"));
		
		// Add hitboxes
		Hitbox squirrelh1 = new Hitbox(7, 5, 32, 22);
		squirrelh1.setBody(true);
		add(squirrelh1);
	}
}
