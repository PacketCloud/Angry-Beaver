package entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Vector;

import engine.LevelSettings;

/*
 * EntityPlayer is the class specific to Moose enemies.
 */
public class EntityMoose extends CombatEntity implements Behavior {
	//TODO: Create Behavior interface, then implement.
	
	public EntityMoose(Point position, Vector velocity, String type, String model, int health, int attackResistance, int knockbackResistance, int attackSpeed, int attackDamage, int attackCooldown, int attackKnockback, int walkSpeed, int jumpHeight) {
		super(position, velocity, type, model, health, attackResistance, knockbackResistance, attackSpeed, attackDamage, attackCooldown, attackKnockback, walkSpeed, jumpHeight);
		//TODO: Add EntityMoose-specific values, methods, and add to constructor.
	}

	@Override
	public void onUpdate(LevelSettings levelSetting) {
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