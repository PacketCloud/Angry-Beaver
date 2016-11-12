package entities;

import java.awt.Graphics2D;
import java.awt.Point;
import ResourceHandling.ResourceCollection;
import states.State;

public class Entity implements EntityInterface {
	private Point Position;
	private Hitbox hitbox;
	private ResourceCollection Model;
	private State EntityState;
		
	public Entity(Point position, Hitbox hitbox, ResourceCollection model, State entityState) {
		super();
		Position = position;
		this.hitbox = hitbox;
		Model = model;
		EntityState = entityState;
	}

	public void update() {
	}
	
	public void draw(Graphics2D g) {
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

	public State getEntityState() {
		return EntityState;
	}

	public void setEntityState(State entityState) {
		EntityState = entityState;
	}

	public void setPosition(Point newPosition) {
		this.Position = newPosition;
	}
	
	public Point getPosition() {
		return this.Position;
	}
	
	public void setState(State state) {
		this.EntityState = state;
	}
	
	public State getState() {
		return this.EntityState;
	}
}
