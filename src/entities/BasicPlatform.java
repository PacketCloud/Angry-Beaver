package entities;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.Level;
import resourceHandling.ResourceCollection;

public class BasicPlatform extends Object {

	public BasicPlatform(Level level, ResourceCollection model) {
		super(level, model);
		initializePlatform();
	}

	public void initializePlatform() {
		this.isSolid = true;
		this.isStatic = true;
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillRect((int) position.getX(), (int) position.getY(), width, height);
	}
}
