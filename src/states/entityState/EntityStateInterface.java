package states.entityState;

import java.awt.Graphics2D;

public interface EntityStateInterface {

	public void update();
	public void render(Graphics2D g);
	
	public void up();
	public void down();
	public void right();
	public void left();
	
	public void pause();
	public void jump();
	public void attack();
	public void attack2();
}
