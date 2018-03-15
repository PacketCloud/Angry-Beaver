package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import behaviour.AbstractBehaviour;
import behaviour.prefab.NoBehaviour;
import engine.Level;
import force.Force;
import hitbox.Hitbox;
import model.AbstractModel;
import model.prefab.EmptyModel;
import resourceHandling.*;
import states.entityState.EntityStateContext;
import trigger.Trigger;

/**
 * Class AbstractEntity is the abstract class for all entities.
 */
public abstract class AbstractEntity {
	
	protected Level level;
	protected AbstractModel model;
	protected AbstractBehaviour behaviour;
	protected EntityStateContext state;
	
	protected Point position;
	protected Point lastPosition;
	protected ArrayList<AbstractEntity> entities;	
	protected Trigger trigger;
	
	protected String id;
	protected double scaling;
	protected boolean facingRight;
	
	// Movement
	protected Set<Force> forces;
	protected boolean isStatic;
	protected int moveSpeedX;
	protected int jumpStrength;
	
	protected boolean isInvulnerable;
	protected int health;
	protected int maxHealth;
	
	public AbstractEntity() {
		// Initialize the entity with default empty properties and values
		this.model = new EmptyModel();
		this.behaviour = new NoBehaviour();
		this.state = new EntityStateContext(this, "Basic_Null_Entity");
		
		this.position = new Point(0, 0);
		this.lastPosition = new Point(0, 0);		
		this.entities = new ArrayList<AbstractEntity>(); // Entities which are related
		
		this.id = UUID.randomUUID().toString();
		this.scaling = 1;
		this.facingRight = false;

		this.forces = new HashSet<Force>();
		this.isStatic = false;
		this.moveSpeedX = 2;
		this.jumpStrength = 3;
		
		this.isInvulnerable = false;
		this.health = 1;
		this.maxHealth = 5;
	}

	public void update() {
		state.checkForNextState();
		
		this.lastPosition = new Point(position);
		
		behaviour.run(this, level);
		// Update movement due to external forces
		updateForces();
	}
	
	private void updateForces() {		
		for (Iterator<Force> iterator = forces.iterator(); iterator.hasNext();) {
		    Force f = iterator.next();
		    if (f.expired) {
		        iterator.remove();
		    } else {
		    	f.update(this);
		    }
		}
	}

	public void render(Graphics2D g) {
		renderTexture(g);
		renderHitboxes(g);
		renderID(g);
	}
	
	public void renderTexture(Graphics2D g) {
		Image texture = model.getImageIcon(state.toString());
		
		// Render image
		if(texture != null) {
			drawImage(g, texture);
			
			// Draw box around image
			g.setColor(Color.WHITE);
			g.drawRect(position.x, position.y , (int) (texture.getWidth(null) * scaling), (int) (texture.getHeight(null) * scaling));
		}
		
		// TODO: Make classes to handle the entity changing colors to change 'Status' 
		if(state.toString().equals("Dying")) {
			Image mask = model.getImageIconMask(state.toString(), Color.red, 0.2f);
			
			drawImage(g, mask);
		}
	}
	
	public void drawImage(Graphics2D g, Image image) {
		int facing = facing();
		
		g.drawImage(image,//image to draw.
				(int) (position.getX() + (-0.5 * facing + 0.5) * image.getWidth(null) * scaling),//x position to draw, dependent on direction facing and scale.
				(int) position.getY(),//y position to draw.
				(int) (image.getWidth(null) * facing * scaling),//dx position to draw, dependent on direction facing and scale.
				(int) (image.getHeight(null) * scaling),//dy position to draw, dependent on scale.
				null);//observer, null.
	}
	
	public void renderHitboxes(Graphics2D g){
		// Temporary rendering of the hitboxes for development purposes
		ArrayList<Hitbox> absoluteHitboxes = getAbsHitboxes();
		
		for(Hitbox h : absoluteHitboxes) {
			// Change color of the hitbox depending on what kind of hitbox it is
			if(h.isTrigger()) {
				g.setColor(Color.RED);
			} else if(h.isBody()) {
				g.setColor(Color.CYAN);
			} else if(h.isSolid()) {
				g.setColor(Color.GREEN);
			} else {
				g.setColor(Color.YELLOW);
			}
			g.drawRect(h.position.x, h.position.y, h.width, h.height);
		}
	}
	
	public void renderID(Graphics2D g) {
		// Printing of ID
		g.drawString(getId(), (int) getPosition().getX(), (int) getPosition().getY());
	}
	
	public void destroy() {
		// Other actions on the destruction of an entity should be handled
		// by the State and the MakeEntity() method
		
		// Destroy all related entities
		for(AbstractEntity e : entities) {
			e.destroy();
		}
		
		level.removeEntity(this);
	}
	
	public void translate(int x, int y) {
		if (!isStatic) {
			position.translate(x, y);
		}
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
	
	// Overridable method inside AbstractEntity to create sub-entities
	public AbstractEntity makeEntity(String entity) {
		return null;
	}
	
	public void addHealth(int value) {
		health += value;
		if (health > maxHealth) {
			health = maxHealth;
		}
	}
	
	public void subHealth(int value) {
		health -= value;
		if (health < 0) {
			health = 0;
		}
	}
	/******** Getters and Setters ********/
	
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

	public void setModel(AbstractModel model) {
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
		this.lastPosition = new Point(position);
	}

	
	public void addHitbox(Hitbox hitbox) {
		model.add(hitbox);
	}
	
	// GetAbsHitboxes will return the hitboxes relative to the world rather than relative to the entity
	// Should tie relative hitboxes to the model rather than to the entity
	public ArrayList<Hitbox> getAbsHitboxes() {
		Image texture = model.getImageIcon(state.toString());
		int facing = facing();
		ArrayList<Hitbox> absHitboxes = new ArrayList<Hitbox>();
		ArrayList<Hitbox> hitboxes = model.getHitboxes();
		
		for (Hitbox h : hitboxes) {
			Hitbox absHitbox = new Hitbox( (int) (position.getX() + ((0.5 * -facing + 0.5) * texture.getWidth(null) * scaling) 
					- (-facing * h.getPosition().getX() * scaling) - ((0.5 * -facing + 0.5) * h.getWidth() * scaling)),//x position to draw, dependent on direction facing and scale.
					(int) (position.getY() + h.getPosition().getY() * scaling),//y position to draw.
					(int) (h.getWidth() * scaling),//dx position to draw, dependent on scale.
					(int) (h.getHeight() * scaling));
			absHitbox.setSolid(h.isSolid());
			absHitbox.setBody(h.isBody());
			absHitbox.setTrigger(h.isTrigger());
			absHitboxes.add(absHitbox);
		}
		return absHitboxes;
	}
	
	public void addForce(Force f) {
		forces.add(f);
	}
	
	public Set<Force> getForces() {
		return forces;
	}

	public void setForces(Set<Force> forces) {
		this.forces = forces;
	}
	
	public void addEntity(AbstractEntity e) {
		entities.add(e);
	}
	
	public void removeEntity(AbstractEntity e) {
		entities.remove(e);
	}
	
	public ArrayList<AbstractEntity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<AbstractEntity> entities) {
		this.entities = entities;
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
	
	public int getJumpStrength() {
		return jumpStrength;
	}

	public void setJumpStrength(int jumpStrength) {
		this.jumpStrength = jumpStrength;
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

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public boolean isInvulnerable() {
		return isInvulnerable;
	}

	public void setInvulnerable(boolean isInvulnerable) {
		this.isInvulnerable = isInvulnerable;
	}

	public Trigger getTrigger() {
		return trigger;
	}

	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}
}
