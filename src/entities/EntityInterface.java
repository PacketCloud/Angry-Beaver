package entities;

import java.awt.Graphics;
import java.awt.Point;

public interface EntityInterface {
	
	public void setPosition(Point newPosition);
	public Point getPosition();
	public void setType(String type);
	public String getType();
	public void setModel(String model);
	public String getModel();

	public void Update();
	public void draw(Graphics g);
	
	// onUpdate() and onDraw() methods will change for
	// each entity class
	public void onUpdate();
	public void onDraw(Graphics g);
	public void onHit();
}
