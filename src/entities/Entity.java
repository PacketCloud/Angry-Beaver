package entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import ResourceHandling.ResourceCollection;

public class Entity implements EntityInterface {
	private Point Position;
	private Hitbox hitbox;
	private ResourceCollection Model;
	private String EntityState;
		
	public Entity(Point position, Hitbox hitbox, ResourceCollection model, String entityState) {
		super();
		Position = position;
		this.hitbox = hitbox;
		Model = model;
		EntityState = entityState;
	}

	public void update() {
	}
	
	public void draw(Graphics2D g) {
		Image texture = Model.getImageIcon(EntityState);
		float textureScale = Model.getImageScale(EntityState);
		g.drawImage(texture, (int) Position.getX(), (int) Position.getY(), (int) (texture.getWidth(null) * textureScale), (int) (texture.getHeight(null) * textureScale), null); //Currently not working. Drawing needs restructuring.
	}
	
	public void hit() {
	}
	
	/******** Getters and Setters ********/
	public Hitbox getHitbox() {
		return hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}

	public ResourceCollection getModel() {
		return Model;
	}

	public void setModel(ResourceCollection model) {
		Model = model;
	}

	public String getEntityState() {
		return EntityState;
	}

	public void setEntityState(String entityState) {
		EntityState = entityState;
	}

	public void setPosition(Point newPosition) {
		this.Position = newPosition;
	}
	
	public Point getPosition() {
		return this.Position;
	}
}
