package entities;

public class Platform {
	Hitbox hitbox;
	
	public Platform(Hitbox hitbox) {
		setHitbox(hitbox);
	}

	public Hitbox getHitbox() {
		return hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}
	
}
