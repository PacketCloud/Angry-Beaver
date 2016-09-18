package entities;

import java.awt.Color;
import java.awt.Graphics2D;

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
	
	public void draw(Graphics2D g) {
		onDraw(g);
	}
	
	public void onDraw(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillRect((int) hitbox.getPosition().getX(), (int) hitbox.getPosition().getY(), hitbox.getWidth(), hitbox.getHeight());
	}
}
