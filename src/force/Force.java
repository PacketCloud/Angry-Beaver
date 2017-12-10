package force;

import entities.AbstractEntity;

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
