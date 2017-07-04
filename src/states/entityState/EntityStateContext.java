package states.entityState;

import java.awt.Graphics2D;

import entities.AbstractEntity;
import states.entityState.basicEntityStates.BasicEntityState;

public class EntityStateContext {
	public EntityStateAbstract entityState;
	public AbstractEntity obj;
	
	public EntityStateContext(AbstractEntity obj, String entityStateName) {
		this.obj = obj;
		initState(entityStateName);
	}
	
	public void initState(String stateName) {
		// Use EntityStateFactory to decide which state to initialize to
		entityState = new BasicEntityState(this);
	}
	
	public void render(Graphics2D g) {
		entityState.render(g, obj);
	}
	
	public void up() {
		entityState.up(obj);
	}
	
	public void down() {
		entityState.down(obj);
	}
	
	public void right() {
		entityState.right(obj);
	}
	
	public void left() {
		entityState.left(obj);
	}
	
	public void jump() {
		entityState.jump(obj);
	}
	
	public void attack() {
		entityState.attack(obj);
	}
	
	public void attack2() {
		entityState.attack2(obj);
	}
}
