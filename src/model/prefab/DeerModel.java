package model.prefab;

import hitbox.Hitbox;
import model.AbstractModel;
import resourceHandling.Resource;
import resourceHandling.ResourceCollection;

public class DeerModel extends AbstractModel {

	public DeerModel() {
		super("Deer");
		initialize();
	}
	
	public void initialize() {
		// TODO: Add other deer resources
		add(new Resource("Deer Default", "/Resources/Sprites/Mobs/Deer/Deer_Idle.gif", (float) 2.5, null, true, "Default"));
		
		add(new Resource("Deer Idle", "/Resources/Sprites/Mobs/Deer/Deer_Idle.gif", (float) 2.5, null, true, "Idle"));
		add(new Resource("Deer Walking", "/Resources/Sprites/Mobs/Deer/Deer_Walking.gif", (float) 2.5, null, true, "Walking"));
		add(new Resource("Deer Falling", "/Resources/Sprites/Mobs/Deer/Deer_Falling.gif", (float) 2.5, null, true, "Falling"));
		add(new Resource("Deer Rising", "/Resources/Sprites/Mobs/Deer/Deer_Rising.gif", (float) 2.5, null, true, "Rising"));
		add(new Resource("Deer Attack", "/Resources/Sprites/Mobs/Deer/Deer_Attack.gif", (float) 2.5, null, true, "Attack1"));
		
		Hitbox deerh= new Hitbox(13, 8, 31, 30);
		deerh.setBody(true);
		add(deerh);
	}
}
