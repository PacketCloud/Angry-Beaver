package model;

import java.util.ArrayList;

import hitbox.Hitbox;
import resourceHandling.ResourceCollection;

public class AbstractModel extends ResourceCollection {
	protected ArrayList<Hitbox> hitboxes;
	
	public AbstractModel(String name) {
		super(name);
		// TODO Auto-generated constructor stub
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
