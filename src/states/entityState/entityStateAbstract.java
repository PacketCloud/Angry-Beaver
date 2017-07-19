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

	public void up(AbstractEntity entity) { }

	public void down(AbstractEntity entity) { }

	public void right(AbstractEntity entity) { }

	public void left(AbstractEntity entity) { }

	public void pause(AbstractEntity entity) { }

	public void jump(AbstractEntity entity) { }
	
	public void attack(AbstractEntity entity) {	}

	public void attack2(AbstractEntity entity) { }

	public void setForNextState(AbstractEntity entity) { }

	public void checkForNextState(AbstractEntity entity) { }
}
