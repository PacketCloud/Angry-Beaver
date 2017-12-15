package entities.prefab;

import java.awt.Image;
import java.awt.Point;

import entities.AbstractEntity;
import hitbox.Hitbox;
import model.AbstractModel;
import model.ClawModel;
import trigger.TriggerFactory;

public class Beaver extends AbstractEntity {

	public Beaver(AbstractModel model) {
		super(model, "Basic Entity");
		// TODO Auto-generated constructor stub
	}

	@Override
	public AbstractEntity makeEntity(String entity) {
		// TODO Auto-generated method stub
		AbstractEntity e = null;
		switch(entity) {
		case "Attack1":
			e = createClaw();
		}
		return e;
	}
	
	public AbstractEntity createClaw() {
		Image texture = model.getImageIcon(state.toString());

		// TODO: Code Cleanup
		// TODO: In line 36, should line up the position of the new entity depending on its width rather than a magic number
		AbstractEntity claw = new Claw(new ClawModel());
		claw.setPosition(new Point((int) ((position.getX() + (-0.5 * facing() + 0.5) * texture.getWidth(null) * scaling) + (-0.5 * facing() - 0.5) * scaling * 16), 
				(int) (position.getY() - 5 * scaling)));

		claw.setScaling(scaling);
		claw.setFacingRight(facingRight);
		claw.setDamage(1);
		
		return claw;
	}

}