package entities;

import java.awt.Graphics;
import java.awt.Point;

/*
 * EntityPlayer is the class specific to the player's character's status.
 */
public class EntityPlayer extends CombatEntity {
	
	public EntityPlayer(Point position, String type, String model, int health, int attackResistance, int knockbackResistance, int attackSpeed, int attackDamage, int attackCooldown, int attackKnockback, int walkSpeed, int jumpHeight) {
		super(position, type, model, health, attackResistance, knockbackResistance, attackSpeed, attackDamage, attackCooldown, attackKnockback, walkSpeed, jumpHeight);
		//TODO: Add EntityPlayer-specific values, methods, and add to constructor.
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDraw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHit() {
		// TODO Auto-generated method stub
		
	}
}
