package entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Vector;

import engine.LevelSettings;

public abstract class Entity implements EntityInterface {
	private Point Position;
	private String Type, Model; //TODO: Change Model to its own type, storing path information for asset(s) and other related data.
	private Vector Velocity;
	EntityStatus status;
	
	public Entity(EntityStatus status) {
		setStatus(status);
	}
	
	public Entity(Point position, Vector velocity, String type, String model) {
		//this.setStatus(status);
		setPosition(position);
		setVelocity(velocity);
		setType(type);
		setModel(model);
	}
	
	
	
	public EntityStatus getStatus() {
		return status;
	}

	public void setStatus(EntityStatus status) {
		this.status = status;
	}

	public void setPosition(Point newPosition) {
		this.Position = newPosition;
	}
	
	public Point getPosition() {
		return this.Position;
	}
	
	public void setVelocity(Vector velocity) {
		this.Velocity = velocity;
	}
	
	public Vector getVelocity() {
		return this.Velocity;
	}
	
	public void setType(String type) {
		this.Type = type;
	}
	
	public String getType() {
		return this.Type;
	}	
	
	public void setModel(String model) {
		this.Model = model;
	}
	
	public String getModel() {
		return this.Model;
	}
	
	public void update(LevelSettings levelSetting) {
		onUpdate(levelSetting);
	}
	
	public void draw(Graphics2D g) {
		onDraw(g);
	}
	
	public void hit() {
		onHit();
	}
}
