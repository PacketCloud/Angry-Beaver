package states.entityState;

import java.awt.Graphics2D;
import java.awt.Point;

import entities.AbstractEntity;

public class EntityStateContext {
	public EntityStateAbstract entityState;
	public AbstractEntity obj;
	
	public EntityStateContext(AbstractEntity obj) {
		this.obj = obj;
		initState(obj.toString());
	}
	
	public void initState(String stateName) {
		// Use EntityStateFactory to decide which state to initialize to
		entityState = new EntityStateFactory().createState(this, stateName);
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
	
	public void translate(int x, int y) {
		obj.getPosition().translate(x, y);
	}

	public EntityStateAbstract getEntityState() {
		return entityState;
	}

	public void setEntityState(EntityStateAbstract entityState) {
		this.entityState = entityState;
	}

	public AbstractEntity getEntity() {
		return obj;
	}

	public void setEntity(AbstractEntity obj) {
		this.obj = obj;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return entityState.stateToString();
	}
	
	public void setForNextState() {
		// TODO Auto-generated method stub
		
	}

	public void checkForNextState() {
		// TODO Auto-generated method stub
		
	}
}
