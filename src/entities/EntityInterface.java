package entities;

import java.awt.Graphics2D;
import java.awt.Point;

import engine.LevelSettings;

public interface EntityInterface {
	
	public void setPosition(Point newPosition);
	public Point getPosition();
	public void setType(String type);
	public String getType();
	public void setModel(String model);
	public String getModel();

	public void update(LevelSettings levelSetting);
	public void draw(Graphics2D g);
	public void hit();

	// onUpdate() and onDraw() methods will change for
	// each entity class
	public void onUpdate(LevelSettings levelSetting);
	public void onDraw(Graphics2D g);
	public void onHit();
}
