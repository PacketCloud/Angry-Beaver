package entities;

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
