package entities.prefab;

import java.awt.Point;

import entities.AbstractEntity;
import hitbox.Hitbox;
import model.CrateModel;
import model.LogModel;
import resourceHandling.ResourceCollection;

public class Tree extends AbstractEntity {

	public Tree(ResourceCollection model) {
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
		Hitbox Logh1 = new Hitbox(1, 1, 20, 13);
		Logh1.setSolid(true);
		Logh1.setBody(true);
		Log.addHitbox(Logh1);
		Log.setScaling(getScaling());
		Log.setHealth(1);
		
		return Log;
	}
}
