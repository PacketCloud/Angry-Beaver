package entities.prefab;

import java.awt.Image;
import java.awt.Point;

import entities.AbstractEntity;
import force.Force;
import force.TimedForce;
import model.prefab.SquirrelModel;
import states.entityState.EntityStateContext;

public class Squirrel extends AbstractEntity {

	public Squirrel() {
		super();
		setModel(new SquirrelModel());
		setState(new EntityStateContext(this, "Basic_Entity"));
	}

	@Override
	public AbstractEntity makeEntity(String entity) {
		// TODO Auto-generated method stub
		AbstractEntity e = null;
		switch(entity) {
		case "Attack1":
			e = createAcorn();
		}
		return e;
	}

	private AbstractEntity createAcorn() {
		Image texture = model.getImageIcon(state.toString());
		
		AbstractEntity acorn = new Acorn();
		// set acorn position relative to current position
		acorn.setPosition(new Point((int) ((position.getX() + (-0.5 * facing() + 0.5) * texture.getWidth(null) * scaling) + (-0.5 * facing() - 0.5) * scaling * 16), 
				(int) (position.getY() - 5 * scaling)));
		
		// set direction, scaling, and damage
		acorn.addForce(new TimedForce(0,-2, 500));
		acorn.addForce(new Force(-7 * facing(), 0));
		acorn.setScaling(scaling);
		acorn.setFacingRight(facingRight);
		
		return acorn;
	}
}
