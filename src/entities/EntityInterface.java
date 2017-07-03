package entities;

import java.awt.Graphics2D;
import java.awt.Point;

import engine.LevelSettings;
import resourceHandling.ResourceCollection;

/* Currently not in use*/

public interface EntityInterface {
	
	public void update();
	public void draw(Graphics2D g);
	public void hit();}
