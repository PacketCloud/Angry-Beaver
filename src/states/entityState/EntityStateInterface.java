package states.entityState;

import java.awt.Graphics2D;

import entities.AbstractEntity;

public interface EntityStateInterface {

	public void render(Graphics2D g, AbstractEntity entity);
	
	public void up(AbstractEntity entity);
	public void down(AbstractEntity entity);
	public void right(AbstractEntity entity);
	public void left(AbstractEntity entity);
	
	public void pause(AbstractEntity entity);
	public void jump(AbstractEntity entity);
	public void attack(AbstractEntity entity);
	public void attack2(AbstractEntity entity);
	
	public String toString();
}
