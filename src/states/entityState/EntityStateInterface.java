package states.entityState;

import java.awt.Graphics2D;

import ResourceHandling.ResourceCollection;

public interface EntityStateInterface {

	public void render(Graphics2D g, ResourceCollection model);
	
	public void up(Object obj);
	public void down(Object obj);
	public void right(Object obj);
	public void left(Object obj);
	
	public void pause(Object obj);
	public void jump(Object obj);
	public void attack(Object obj);
	public void attack2(Object obj);
}
