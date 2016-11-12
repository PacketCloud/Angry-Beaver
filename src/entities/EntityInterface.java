package entities;

import java.awt.Graphics2D;
import java.awt.Point;

import ResourceHandling.ResourceCollection;
import engine.LevelSettings;

public interface EntityInterface {
	
	public void update();
	public void draw(Graphics2D g);
	public void hit();

	// onUpdate() and onDraw() methods will change for
	// each entity class
	//public void onUpdate();
	//public void onDraw(Graphics2D g);
	//public void onHit();
}
