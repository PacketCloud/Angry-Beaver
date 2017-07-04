package entities;

import java.awt.Graphics2D;
import java.awt.Image;

import engine.Level;
import resourceHandling.ResourceCollection;

public class BasicEntity extends AbstractEntity {
	private int health;

	public BasicEntity(Level level, ResourceCollection model) {
		super(level, model);
		initializeEntity();
	}
	
	public void initializeEntity() {
		this.health = 0;
	}
}
