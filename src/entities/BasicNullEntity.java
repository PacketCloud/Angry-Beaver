package entities;

import java.awt.Color;
import java.awt.Graphics2D;

import behaviour.AbstractBehaviour;
import engine.Level;
import resourceHandling.ResourceCollection;

public class BasicNullEntity extends AbstractEntity {

	public BasicNullEntity(ResourceCollection model) {
		super(model);
		initializePlatform();
	}

	public void initializePlatform() {
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Basic Null Entity";
	}
}
