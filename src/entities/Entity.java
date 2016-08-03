package entities;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Entity implements EntityInterface {
	private Point Position;
	private String Type, Model; //TODO: Change Model to its own type, storing path information for asset(s) and other related data.
	
	public Entity(Point position, String type, String Model) {
		this.setPosition(position);
		this.setType(type);
		this.setModel(Model);
	}
	
	public void setPosition(Point newPosition) {
		this.Position = newPosition;
	}
	
	public Point getPosition() {
		return this.Position;
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
	
	public void update() {
		onUpdate();
	}
	
	public void draw(Graphics g) {
		onDraw(g);
	}
	
	public void hit() {
		onHit();
	}
}
