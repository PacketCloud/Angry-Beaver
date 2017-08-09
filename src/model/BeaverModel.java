package model;

import java.util.ArrayList;

import hitbox.Hitbox;
import resourceHandling.Resource;
import resourceHandling.ResourceCollection;

public class BeaverModel extends ResourceCollection {

	public BeaverModel() {
		super("Beaver");
		initialize();
	}
	
	public void initialize() {
		
		/*Hitbox playerh= new Hitbox(2, 2, 20, 15);
		playerh.setBody(true);
		ArrayList<Hitbox> hitboxes = new ArrayList<Hitbox>();
		hitboxes.add(playerh);*/
		
		add(new Resource("Beaver Walking", "/Resources/Sprites/Player/Beaver_Walking.gif", (float) 2.5, null, true, "Walking"));
		add(new Resource("Beaver Idle", "/Resources/Sprites/Player/Beaver_Idle.png", (float) 2.5, null, true, "Idle"));
		add(new Resource("Beaver Falling", "/Resources/Sprites/Player/Beaver_Falling.png", (float) 2.5, null, true, "Falling"));
		add(new Resource("Beaver Rising", "/Resources/Sprites/Player/Beaver_Idle.png", (float) 2.5, null, true, "Rising"));
		add(new Resource("Beaver Attack", "/Resources/Sprites/Player/Beaver_Munch.gif", (float) 2.5, null, true, "Attack1"));
	}

}
