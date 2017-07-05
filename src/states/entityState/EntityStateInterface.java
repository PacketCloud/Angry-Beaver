package states.entityState;

import java.awt.Graphics2D;
import java.awt.Point;

import entities.AbstractEntity;
import resourceHandling.ResourceCollection;

public interface EntityStateInterface {

	public void render(Graphics2D g, ResourceCollection model, Point pos);
	
	public void up(AbstractEntity entity);
	public void down(AbstractEntity entity);
	public void right(AbstractEntity entity);
	public void left(AbstractEntity entity);
	
	public void pause(AbstractEntity entity);
	public void jump(AbstractEntity entity);
	public void attack(AbstractEntity entity);
	public void attack2(AbstractEntity entity);
	
	public void setForNextState(AbstractEntity entity);
	public void checkForNextState(AbstractEntity entity);
	
	public String stateToString();
}
