package force;

import entities.AbstractEntity;

/**
 * Class Force defines a translation of pixels per frame/tick
 * When applied to an Entity, it will translate the position
 * of the entity based on dx and dy values.
 *
 */
public class Force {
	int dx;
	int dy;
	public boolean expired;
	
	public Force(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
		this.expired = false;
	}
	
	public void update(AbstractEntity e) {
		e.translate(dx, dy);
	}
}
