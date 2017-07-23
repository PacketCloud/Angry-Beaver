package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import behaviour.AbstractBehaviour;
import behaviour.NoBehaviour;
import engine.Level;
import hitbox.Hitbox;
import resourceHandling.ResourceCollection;
import states.entityState.EntityStateAbstract;
import states.entityState.EntityStateContext;

public abstract class AbstractEntity {
	
	protected Level level;
	protected ResourceCollection model;
	protected AbstractBehaviour behaviour;
	protected EntityStateContext state;
	
	protected Point position;
	protected Point lastPosition;
	protected ArrayList<Hitbox> hitboxes;
	
	protected String id;
	protected double scaling;
	protected boolean facingRight;
	protected boolean lastFacing;
	
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
		this.lastPosition = new Point(0, 0);
		this.hitboxes = new ArrayList<Hitbox>(); // Hitboxes relative to the entity
		
		this.id = null;
		this.scaling = 1;
		this.facingRight = true;

		this.isStatic = false;
		
		this.moveSpeedX = 2;
		this.moveSpeedY = 2;
	}

	public void update() {
		this.lastPosition = new Point(position);
		//state.setForNextState();
		behaviour.run(this);
		// Update movement due to external forces
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
		ArrayList<Hitbox> absoluteHitboxes = getAbsHitboxes();
		
		for(Hitbox h : absoluteHitboxes) {
			g.drawRect(h.position.x, h.position.y, h.width, h.height);
		}
	}
	
	public void isHit() {
		// Not used
	}
	
	public void destroy() {
		level.removeEntity(this);
	}
	
	public void hasIntersected(AbstractEntity obj) {
		// Not used
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
	
	public int facing() {
		if(facingRight) {
			return -1;
		}
		return 1;
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
	
	// GetAbsHitboxes will return the hitboxes relative to the world rather than relative to the entity
	// Should tie relative hitboxes to the model rather than to the entity
	public ArrayList<Hitbox> getAbsHitboxes() {
		Image texture = model.getImageIcon(state.toString());
		int facing = facing();
		ArrayList<Hitbox> absHitboxes = new ArrayList<Hitbox>();
		
		for (Hitbox h : hitboxes) {
			Hitbox absHitbox = new Hitbox( (int) (position.getX() + ((0.5 * facing + 0.5) * texture.getWidth(null) * scaling) 
					- (facing * h.getPosition().getX() * scaling) - ((0.5 * facing + 0.5) * h.getWidth() * scaling)),//x position to draw, dependent on direction facing and scale.
					(int) (position.getY() + h.getPosition().getY() * scaling),//y position to draw.
					(int) (h.getWidth() * scaling),//dx position to draw, dependent on scale.
					(int) (h.getHeight() * scaling));
			absHitboxes.add(absHitbox);
		}
		return absHitboxes;
	}

	public void setHitboxes(ArrayList<Hitbox> hitboxes) {
		this.hitboxes = hitboxes;
	}
	
	public void removeHitbox(Hitbox hitbox) {
		hitboxes.remove(hitbox);
	}
	
	public boolean isFacingRight() {
		return facingRight;
	}
	
	public void setFacingRight(boolean facingRight) {
		this.facingRight = facingRight;
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
	
	public Point getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(Point lastPosition) {
		// Not required?
		this.lastPosition = lastPosition;
	}
}
