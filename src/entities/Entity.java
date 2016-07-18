package entities;

import java.awt.Point;

public class Entity {
	private Point Position;
	private String Type, Model;
	
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
}
