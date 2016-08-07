package entities;

import java.awt.Graphics2D;
import java.awt.Point;

import engine.LevelSettings;

/*
 * EntityPlayer is the class specific to Lumberjack enemies.
 */
public class EntityLumberjack extends CombatEntity implements Behavior {
	//TODO: Create Behavior interface, then implement.
	
	public EntityLumberjack(Point position, String type, String model, int health, int attackResistance, int knockbackResistance, int attackSpeed, int attackDamage, int attackCooldown, int attackKnockback, int walkSpeed, int jumpHeight) {
		super(position, type, model, health, attackResistance, knockbackResistance, attackSpeed, attackDamage, attackCooldown, attackKnockback, walkSpeed, jumpHeight);
		//TODO: Add EntityLumberjack-specific values, methods, and add to constructor.
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