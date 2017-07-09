package entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

import behaviour.AbstractBehaviour;
import behaviour.NoBehaviour;
import engine.Level;
import resourceHandling.ResourceCollection;
import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

public abstract class AbstractEntity {
	
	protected Level level;
	protected ResourceCollection model;
	protected AbstractBehaviour behaviour;
	
	//TODO: entityStateContext is required
	protected EntityStateContext state;
	
	protected Point position;
	protected int width;
	protected int height;
	
	protected String id;

	protected boolean facingRight;
	protected boolean isSolid;
	protected boolean isStatic;
	
	protected int moveSpeedX;
	protected int moveSpeedY;
	
	
	public AbstractEntity(ResourceCollection model) {
		initialize(model);
	}
	
	public void initialize(ResourceCollection model) {
		this.model = model;
		this.behaviour = new NoBehaviour();
		this.state = new EntityStateContext(this);
		
		this.position = new Point(0, 0);
		this.width = 10;
		this.height = 10;
		
		this.id = null;
		
		this.facingRight = true;
		this.isSolid = false;
		this.isStatic = false;
		
		this.moveSpeedX = 2;
		this.moveSpeedY = 2;
	}
	
	public void update() {
		state.setForNextState();
		behaviour.run(this);
		state.checkForNextState();
	}
	
	public void render(Graphics2D g) {
		state.render(g);
	}
	
	public void isHit() {
		
	}
	
	public void destroy() {
		level.removeEntity(this);
	}
	
	public void hasIntersected(AbstractEntity obj) {
		if (!isSolid) {
			position.setLocation(0, 0);
		}
	}
	
	public void translate(int x, int y) {
		position.translate(x, y);
	}

	public void up() {
		state.up();
	}
	
	public void down() {
		state.down();
	}
	
	public void right() {
		state.right();
	}
	
	public void left() {
		state.left();
	}
	
	public void jump() {
		state.jump();
	}
	
	public void attack() {
		state.attack();
	}
	
	public void attack2() {
		state.attack2();
	}
	
	/* Getters and Setters */
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public ResourceCollection getModel() {
		return model;
	}

	public void setModel(ResourceCollection model) {
		this.model = model;
	}

	public AbstractBehaviour getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(AbstractBehaviour behaviour) {
		this.behaviour = behaviour;
	}

	public EntityStateContext getState() {
		return state;
	}

	public void setState(EntityStateContext state) {
		this.state = state;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isFacingRight() {
		return facingRight;
	}

	public int facing() {
		if(facingRight) {
			return -1;
		}
		return 1;
	}
	
	public void setFacingRight(boolean facingRight) {
		this.facingRight = facingRight;
	}
	
	public boolean isSolid() {
		return isSolid;
	}

	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	public int getMoveSpeedX() {
		return moveSpeedX;
	}

	public void setMoveSpeedX(int moveSpeedX) {
		this.moveSpeedX = moveSpeedX;
	}

	public int getMoveSpeedY() {
		return moveSpeedY;
	}

	public void setMoveSpeedY(int moveSpeedY) {
		this.moveSpeedY = moveSpeedY;
	}
}
