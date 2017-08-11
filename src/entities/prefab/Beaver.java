package entities.prefab;

import java.awt.Image;
import java.awt.Point;

import entities.AbstractEntity;
import entities.BasicEntity;
import hitbox.Hitbox;
import model.ClawModel;
import resourceHandling.ResourceCollection;
import trigger.TriggerFactory;

public class Beaver extends BasicEntity {

	public Beaver(ResourceCollection model) {
		super(model);
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
		
		AbstractEntity claw = new BasicEntity(new ClawModel());
		claw.setPosition(new Point((int) ((position.getX() + (-0.5 * facing() + 0.5) * texture.getWidth(null) * scaling) + (-0.5 * facing() - 0.5) * scaling * 16), 
				(int) (position.getY() - 5 * scaling)));
		Hitbox clawh1 = new Hitbox(2, 2, 12, 24);
		clawh1.setTrigger(true);
		claw.addHitbox(clawh1);
		claw.setTrigger(new TriggerFactory().createTrigger("Damage"));
		claw.setStatic(true);
		claw.setScaling(scaling);
		claw.setFacingRight(facingRight);
		claw.setDamage(1);
		
		return claw;
	}

}