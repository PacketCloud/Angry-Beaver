package entities.prefab;

import java.awt.Image;
import java.awt.Point;

import entities.AbstractEntity;
import hitbox.Hitbox;
import model.AbstractModel;
import model.UppercutModel;
import trigger.TriggerFactory;

public class Deer extends AbstractEntity {

	public Deer(AbstractModel model) {
		super(model, "Basic Entity");
		// TODO Auto-generated constructor stub
	}

	@Override
	public AbstractEntity makeEntity(String entity) {
		// TODO Auto-generated method stub
		AbstractEntity e = null;
		
		switch(entity) {
		case "Attack1":
			e = createUppercut();
		}
		return e;
	}
	
	public AbstractEntity createUppercut() {
		Image texture = model.getImageIcon(state.toString());
		
		// TODO: In line 36, should line up the position of the new entity depending on its width rather than a magic number
		AbstractEntity Uppercut = new Uppercut(new UppercutModel());
		Uppercut.setPosition(new Point((int) ((position.getX() + (-0.5 * facing() + 0.5) * texture.getWidth(null) * scaling) + (-0.5 * facing() - 0.5) * scaling * 24), 
				(int) (position.getY() - 5 * scaling)));
		Hitbox clawh1 = new Hitbox(4, 3, 17, 44);
		clawh1.setTrigger(true);
		Uppercut.addHitbox(clawh1);
		Uppercut.setTrigger(new TriggerFactory().createTrigger("Damage KnockBack:-2:-10:250"));
		Uppercut.setStatic(true);
		Uppercut.setScaling(scaling);
		Uppercut.setFacingRight(facingRight);
		Uppercut.setDamage(1);
		
		return Uppercut;
	}
}
