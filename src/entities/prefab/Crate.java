package entities.prefab;

import entities.AbstractEntity;
import model.AbstractModel;
import model.CrateModel;

public class Crate extends AbstractEntity {

	public Crate() {
		super();
		setModel(new CrateModel());
	}
}
