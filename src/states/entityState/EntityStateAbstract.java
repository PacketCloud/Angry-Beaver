package states.entityState;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

import entities.AbstractEntity;
import resourceHandling.ResourceCollection;

public abstract class EntityStateAbstract implements EntityStateInterface {
	protected EntityStateContext context;
	
	public EntityStateAbstract(EntityStateContext context) {
		this.context = context;
	}

	public void up() { }

	public void down() { }

	public void right() { }

	public void left() { }

	public void pause() { }

	public void jump() { }
	
	public void attack() {	}

	public void attack2() { }
}
