package entities.prefab;

import java.awt.Point;

import entities.AbstractEntity;
import hitbox.Hitbox;
import model.AbstractModel;
import model.LogModel;

public class Tree extends AbstractEntity {

	public Tree(AbstractModel model) {
		super(model, "Basic Null Entity");
		// TODO Auto-generated constructor stub
	}

	@Override
	public AbstractEntity makeEntity(String entity) {
		// TODO Auto-generated method stub
		AbstractEntity e = null;
		switch (entity) {
		case "Dying":
			e = createLog();
		}
		return e;
	}

	public AbstractEntity createLog() {
		AbstractEntity Log = new Log(new LogModel());
		Log.setPosition(new Point(getPosition()));
		Log.setScaling(getScaling());
		Log.setHealth(1);
		
		return Log;
	}
}
