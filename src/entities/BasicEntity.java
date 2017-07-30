package entities;

import java.awt.Graphics2D;
import java.awt.Image;

import behaviour.AbstractBehaviour;
import engine.Level;
import resourceHandling.ResourceCollection;

public class BasicEntity extends AbstractEntity {

	public BasicEntity(ResourceCollection model) {
		super(model);
		initializeEntity();
	}
	
	public void initializeEntity() {
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Basic Entity";
	}
}
