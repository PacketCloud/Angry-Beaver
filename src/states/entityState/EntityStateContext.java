package states.entityState;

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
		entityState.up();
	}
	
	public void down() {
		entityState.down();
	}
	
	public void right() {
		entityState.right();
	}
	
	public void left() {
		entityState.left();
	}
	
	public void jump() {
		entityState.jump();
	}
	
	public void attack() {
		entityState.attack();
	}
	
	public void attack2() {
		entityState.attack2();
	}
	
	public void translate(int x, int y) {
		obj.translate(x, y);
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

	public void checkForNextState() {
		// TODO Auto-generated method stub
		entityState.checkForNextState();
	}
	
	public Point getCurrentPosition() {
		return obj.getPosition();
	}
	
	public Point getLastPosition() {
		return obj.getLastPosition();
	}
	
	public boolean isFacingRight() {
		return obj.isFacingRight();
	}
	
	public double getScaling() {
		return obj.getScaling();
	}

	public AbstractEntity makeEntity(String entity) {
		// TODO Auto-generated method stub
		return obj.makeEntity(entity);
	}
	
	public void addSubEntity(AbstractEntity e) {
		obj.addEntity(e);
	}
	
	public void removeSubEntity(AbstractEntity e) {
		obj.removeEntity(e);
	}
	
	public void destroy() {
		obj.destroy();
	}
	
	public int getMoveSpeedX() {
		return obj.getMoveSpeedX();
	}
	
	public int getJumpStrength() {
		return obj.getJumpStrength();
	}
}
