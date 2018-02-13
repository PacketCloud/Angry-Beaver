package model.prefab;

import hitbox.Hitbox;
import model.AbstractModel;
import resourceHandling.Resource;

public class BeaverModel extends AbstractModel {

	public BeaverModel() {
		super("Beaver");
		initialize();
	}
	
	public void initialize() {		
		add(new Resource("Beaver Default", "/Resources/Sprites/Mobs/Beaver/Beaver_Idle.png", (float) 2.5, null, true, "Default"));
		
		add(new Resource("Beaver Walking", "/Resources/Sprites/Mobs/Beaver/Beaver_Walking.gif", (float) 2.5, null, true, "Walking"));
		add(new Resource("Beaver Idle", "/Resources/Sprites/Mobs/Beaver/Beaver_Idle.png", (float) 2.5, null, true, "Idle"));
		add(new Resource("Beaver Falling", "/Resources/Sprites/Mobs/Beaver/Beaver_Falling.png", (float) 2.5, null, true, "Falling"));
		add(new Resource("Beaver Rising", "/Resources/Sprites/Mobs/Beaver/Beaver_Idle.png", (float) 2.5, null, true, "Rising"));
		add(new Resource("Beaver Attack", "/Resources/Sprites/Mobs/Beaver/Beaver_Munch.gif", (float) 2.5, null, true, "Attack1"));
		Hitbox beaverh1= new Hitbox(2, 2, 20, 15);
		beaverh1.setBody(true);
		add(beaverh1);
	}

}
