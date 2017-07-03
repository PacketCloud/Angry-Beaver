package entities;

import java.awt.Graphics2D;
import java.awt.Image;

import ResourceHandling.ResourceCollection;
import engine.Level;

public class BasicEntity extends Object {
	private int health;

	public BasicEntity(Level level, ResourceCollection model) {
		super(level, model);
		initializeEntity();
	}
	
	public void initializeEntity() {
		this.health = 0;
	}

	@Override
	public void render(Graphics2D g) {
		
		Image texture = model.getImageIcon("Walking");
		float textureScale = model.getImageScale("Walking");
		g.drawImage(texture,//image to draw.
			(int) (position.getX() + (-0.5 * 1 + 0.5) * texture.getWidth(null) * textureScale),//x position to draw, dependent on direction facing and scale.
			(int) position.getY(),//y position to draw.
			(int) (texture.getWidth(null) * textureScale),//dx position to draw, dependent on direction facing and scale.
			(int) (texture.getHeight(null) * textureScale),//dy position to draw, dependent on scale.
			null);//observer, null.
			
	}
	
}
