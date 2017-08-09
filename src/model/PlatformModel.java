package model;

import java.util.ArrayList;

import hitbox.Hitbox;
import resourceHandling.Resource;
import resourceHandling.ResourceCollection;

public class PlatformModel extends ResourceCollection {

	public PlatformModel() {
		super("Platform");
		// TODO Auto-generated constructor stub
		initialize();
	}
	
	public void initialize() {
		/*Hitbox plath =  new Hitbox(800, 50);
		plath.setSolid(true);		
		ArrayList<Hitbox> hitboxes = new ArrayList<Hitbox>();
		hitboxes.add(plath);
		*/
		add(new Resource("Grass1", "/Resources/Textures/Environment/grass1.png", (float) 2.5, null, true, "NoEntityState"));
		
	}

}
