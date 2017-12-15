package entities.prefab;

import entities.AbstractEntity;
import model.AbstractModel;
import model.LogModel;

public class Log extends AbstractEntity {

	public Log(AbstractModel model) {
		super();
		// TODO Auto-generated constructor stub
		setModel(new LogModel());
	}

}
