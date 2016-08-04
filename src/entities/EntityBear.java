package entities;

import java.awt.Graphics2D;
import java.awt.Point;

/*
 * EntityPlayer is the class specific to Bear enemies.
 */
public class EntityBear extends CombatEntity implements Behavior {
	//TODO: Create Behavior interface, then implement.
	
	public EntityBear(Point position, String type, String model, int health, int attackResistance, int knockbackResistance, int attackSpeed, int attackDamage, int attackCooldown, int attackKnockback, int walkSpeed, int jumpHeight) {
		super(position, type, model, health, attackResistance, knockbackResistance, attackSpeed, attackDamage, attackCooldown, attackKnockback, walkSpeed, jumpHeight);
		//TODO: Add EntityBear-specific values, methods, and add to constructor.
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDraw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHit() {
		// TODO Auto-generated method stub
		
	}
}