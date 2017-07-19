package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

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
	protected EntityStateContext state;
	
	protected Point position;
	protected ArrayList<Hitbox> hitboxes;
	
	protected String id;
	protected double scaling;
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
		this.hitboxes = new ArrayList<Hitbox>();
		
		this.id = null;
		this.scaling = 1;
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
		//state.render(g);
		
		Image texture = model.getImageIcon(state.toString());
		//float textureScale = model.getImageScale(state.toString());
		int facing = facing();
		
		// Render image
		if(texture != null) {
			g.drawImage(texture,//image to draw.
				(int) (position.getX() + (-0.5 * facing + 0.5) * texture.getWidth(null) * scaling),//x position to draw, dependent on direction facing and scale.
				(int) position.getY(),//y position to draw.
				(int) (texture.getWidth(null) * facing * scaling),//dx position to draw, dependent on direction facing and scale.
				(int) (texture.getHeight(null) * scaling),//dy position to draw, dependent on scale.
				null);//observer, null.
			g.setColor(Color.WHITE);
			g.drawRect(position.x, position.y , (int) (texture.getWidth(null) * scaling), (int) (texture.getHeight(null) * scaling));
		}
				
		// Temporary rendering of the hitboxes
		g.setColor(Color.GREEN);
		
		for(Hitbox h : hitboxes) {			
			g.drawRect(
					(int) (position.getX() + ((0.5 * facing + 0.5) * texture.getWidth(null) * scaling) 
							- (facing * h.getPosition().getX() * scaling) - ((0.5 * facing + 0.5) * h.getWidth() * scaling)),//x position to draw, dependent on direction facing and scale.
					(int) (position.getY() + h.getPosition().getY() * scaling),//y position to draw.
					(int) (h.getWidth() * scaling),//dx position to draw, dependent on scale.
					(int) (h.getHeight() * scaling)//dy position to draw, dependent on scale.
					);
		}
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

	public void addHitbox(Hitbox hitbox) {
		hitboxes.add(hitbox);
	}
	
	public void removeHitbox(Hitbox hitbox) {
		hitboxes.remove(hitbox);
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
	
	public double getScaling() {
		return scaling;
	}

	public void setScaling(double scaling) {
		this.scaling = scaling;
	}
}
