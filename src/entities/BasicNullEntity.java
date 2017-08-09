package entities;

import resourceHandling.ResourceCollection;

public class BasicNullEntity extends AbstractEntity {

	public BasicNullEntity(ResourceCollection model) {
		super(model);
		initializeNullEntity();
	}

	public void initializeNullEntity() {
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Basic Null Entity";
	}
}
