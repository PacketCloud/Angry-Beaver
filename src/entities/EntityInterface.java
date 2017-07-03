package entities;

import java.awt.Graphics2D;
import java.awt.Point;

import ResourceHandling.ResourceCollection;
import engine.LevelSettings;

/* Currently not in use*/

public interface EntityInterface {
	
	public void update();
	public void draw(Graphics2D g);
	public void hit();}
