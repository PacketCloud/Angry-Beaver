package entities;

import basic_types.Coords;

public class Entity {
	private Coords Position;
	private String Type, Model;
	
	public Entity(Coords position, String type, String Model) {
		this.setPosition(position);
		this.setType(type);
		this.setModel(Model);
	}
	
	public void setPosition(Coords newPosition) {
		this.Position = newPosition;
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
