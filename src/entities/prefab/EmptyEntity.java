package entities.prefab;

import entities.AbstractEntity;
import model.prefab.EmptyModel;

public class EmptyEntity extends AbstractEntity {

	public EmptyEntity() {
		super();
		setModel(new EmptyModel());
	}
	
}
