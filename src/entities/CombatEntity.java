package entities;

import java.awt.Point;

public class CombatEntity extends Entity {
	private int Health, AttackResistance, KnockbackResistance, AttackSpeed, AttackDamage, AttackCooldown, AttackKnockback, WalkSpeed, JumpHeight;

	public CombatEntity(Point position, String type, String model, int health, int attackResistance, int knockbackResistance, int attackSpeed, int attackDamage, int attackCooldown, int attackKnockback, int walkSpeed, int jumpHeight) {
		super(position, type, model);
		this.setHealth(health);
		this.setAttackResistance(attackResistance);
		this.setKnockbackResistance(knockbackResistance);
		this.setAttackSpeed(attackSpeed);
		this.setAttackDamage(attackDamage);
		this.setAttackCooldown(attackCooldown);
		this.setAttackKnockback(attackKnockback);
		this.setWalkSpeed(walkSpeed);
		this.setJumpHeight(jumpHeight);
	}
	
	public void setHealth(int health) {
		this.Health = health;
	}
	
	public int getHealth() {
		return this.Health;
	}
	
	public void setAttackResistance(int attackResistance) {
		this.AttackResistance = attackResistance;
	}
	
	public int getAttackResistance() {
		return this.AttackResistance;
	}
	
	public void setKnockbackResistance(int knockbackResistance) {
		this.KnockbackResistance = knockbackResistance;
	}
	
	public int getKnockbackResistance() {
		return this.KnockbackResistance;
	}
	
	public void setAttackSpeed(int attackSpeed) {
		this.AttackSpeed = attackSpeed;
	}
	
	public int getAttackSpeed() {
		return this.AttackSpeed;
	}
	
	public void setAttackDamage(int attackDamage) {
		this.AttackDamage = attackDamage;
	}
	
	public int getAttackDamage() {
		return this.AttackDamage;
	}
	
	public void setAttackCooldown(int attackCooldown) {
		this.AttackCooldown = attackCooldown;
	}
	
	public int getAttackCooldown(int attackCooldown) {
		return this.AttackCooldown;
	}
	
	public void setAttackKnockback(int attackKnockback) {
		this.AttackKnockback = attackKnockback;
	}
	
	public int getAttackKnockback() {
		return this.AttackKnockback;
	}
	
	public void setWalkSpeed(int walkSpeed) {
		this.WalkSpeed = walkSpeed;
	}
	
	public int getWalkSpeed() {
		return this.WalkSpeed;
	}
	
	public void setJumpHeight(int jumpHeight) {
		this.JumpHeight = jumpHeight;
	}
	
	public int getJumpHeight() {
		return this.JumpHeight;
	}
}
