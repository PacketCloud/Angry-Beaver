package entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Vector;

import engine.LevelSettings;
import entities.EntityStatus;
import ResourceHandling.ResourceCollection;
import states.State;

public abstract class Entity implements EntityInterface {
	private Point Position;
	private String Type; //TODO: Change Model to its own type, storing path information for asset(s) and other related data (ResourceHandling.ResourceCollection).
	private float Velocity;
	private String Facing;
	private ResourceCollection Model;
	private EntityStatus status;
	private State EntityState;
	
	public Entity(EntityStatus status) {
		setStatus(status);
	}
	
	public Entity(Point position, float velocity, String type, ResourceCollection model, String facing, State state) {
		//this.setStatus(status);
		setPosition(position);
		setVelocity(velocity);
		setType(type);
		setEntityModel(model);
		setFacing(facing);
		setState(state);
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
	
	public void setVelocity(float velocity) {
		this.Velocity = velocity;
	}
	
	public float getVelocity() {
		return this.Velocity;
	}
	
	public String getFacing() {
		return this.Facing;
	}
	
	public void setFacing(String facing) {
		if (facing == "left"|facing == "right") {
			this.Facing = facing;
			return;
		}
		if(this.Facing == null) {
			this.Facing = "right";
		}
		//TODO: Throw exception, since facing was invalid string.
	}
	
	public void setType(String type) {
		this.Type = type;
	}
	
	public String getType() {
		return this.Type;
	}	
	
	public void setEntityModel(ResourceCollection model) {
		this.Model = model;
	}
	
	public ResourceCollection getEntityModel() {
		return this.Model;
	}
	
	public void setState(State state) {
		this.EntityState = state;
	}
	
	public State getState() {
		return this.EntityState;
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
