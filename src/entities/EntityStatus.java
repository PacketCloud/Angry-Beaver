package entities;

public class EntityStatus {
	Hitbox hitbox;
	
	public EntityStatus(Hitbox hitbox) {
		setHitbox(hitbox);
	}

	public Hitbox getHitbox() {
		return hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}
	
}
