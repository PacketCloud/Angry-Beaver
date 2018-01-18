package model;

import java.util.ArrayList;

import hitbox.Hitbox;
import resourceHandling.ResourceCollection;

/**
 * Class AbstractModel is the abstract class for all models.
 * Models contain a collection of Resources or assets such as
 * sound and textures.
 * 
 * Entities with a model can access model assets.
 *
 */
public class AbstractModel extends ResourceCollection {
	protected ArrayList<Hitbox> hitboxes;
	
	public AbstractModel(String name) {
		super(name);
		this.hitboxes = new ArrayList<Hitbox>();
	}
	
	public ArrayList<Hitbox> getHitboxes() {
		return hitboxes;
	}
	
	public void add(Hitbox hitbox) {
		hitboxes.add(hitbox);
	}
	
	public void setHitboxes(ArrayList<Hitbox> hitboxes) {
		this.hitboxes = hitboxes;
	}
	
	public void removeHitbox(Hitbox hitbox) {
		hitboxes.remove(hitbox);
	}
}
