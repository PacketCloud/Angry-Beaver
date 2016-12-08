package entities;

import java.awt.Graphics2D;
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
		//g.drawImage(Model.getImageIcon(EntityState).getImage(), (int) Position.getX(), (int) Position.getY(), null); //Currently not working. Drawing needs restructuring.
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
