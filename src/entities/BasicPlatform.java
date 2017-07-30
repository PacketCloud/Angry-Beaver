package entities;

import java.awt.Color;
import java.awt.Graphics2D;

import behaviour.AbstractBehaviour;
import engine.Level;
import resourceHandling.ResourceCollection;

public class BasicPlatform extends AbstractEntity {

	public BasicPlatform(ResourceCollection model) {
		super(model);
		initializePlatform();
	}

	public void initializePlatform() {
		this.isStatic = true;
		this.isInvulnerable = true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Basic Platform";
	}
}
