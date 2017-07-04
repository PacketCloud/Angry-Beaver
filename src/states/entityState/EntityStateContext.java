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
	
	public Point getPosition() {
		return obj.getPosition();
	}
	
	public int getMoveSpeedX() {
		return obj.getMoveSpeedX();
	}
	
	public int getMoveSpeedY() {
		return obj.getMoveSpeedY();
	}
	
	public void translate(int x, int y) {
		getPosition().translate(x, y);
	}
}
