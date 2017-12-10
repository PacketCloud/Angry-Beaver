package states.entityState;

import java.awt.Graphics2D;
import java.awt.Point;

import entities.AbstractEntity;
import resourceHandling.ResourceCollection;

public interface EntityStateInterface {
	
	public void up();
	public void down();
	public void right();
	public void left();
	
	public void pause();
	public void jump();
	public void attack();
	public void attack2();
	
	public void checkForNextState();
	
	public String stateToString();
}
