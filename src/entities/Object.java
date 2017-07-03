package entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

import engine.Level;
import resourceHandling.ResourceCollection;
import states.entityState.EntityStateAbstract;

public abstract class Object {
	
	protected Level level;
	protected ResourceCollection model;
	protected int behaviour;
	
	//TODO: entityStateContext is required
	protected EntityStateAbstract state;
	
	protected Point position;
	protected int width;
	protected int height;
	
	protected String id;

	protected boolean facingRight;
	protected boolean isSolid;
	protected boolean isStatic;
	
	protected int moveSpeedX;
	protected int moveSpeedY;
	
	
	public Object(Level level, ResourceCollection model) {
		initialize(level, model);
	}
	
	public void initialize(Level level, ResourceCollection model) {
		this.level = level;
		this.model = model;
		this.behaviour = 0;
		this.state = null;
		
		this.position = new Point(0, 0);
		this.width = 10;
		this.height = 10;
		
		this.id = null;
		
		this.facingRight = true;
		this.isSolid = false;
		this.isStatic = false;
		
		this.moveSpeedX = 5;
		this.moveSpeedY = 5;
	}
	
	public void update() {
		// From Behaviour;
	}
	
	public void render(Graphics2D g) {
		/*
		Image texture = Model.getImageIcon(EntityState);
		float textureScale = Model.getImageScale(EntityState);
		g.drawImage(texture,//image to draw.
			(int) (Position.getX() + (-0.5 * getFacing() + 0.5) * texture.getWidth(null) * textureScale),//x position to draw, dependent on direction facing and scale.
			(int) Position.getY(),//y position to draw.
			(int) (texture.getWidth(null) * textureScale * getFacing()),//dx position to draw, dependent on direction facing and scale.
			(int) (texture.getHeight(null) * textureScale),//dy position to draw, dependent on scale.
			null);//observer, null.
			*/
	}
	
	public void isHit() {
		
	}
	
	public void destroy() {
		
	}
	
	public void intersects(Object obj) {
		
	}
	
	public void translate(int x, int y) {
		position.translate(x, y);
	}

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

	public int getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(int behaviour) {
		this.behaviour = behaviour;
	}

	public EntityStateAbstract getState() {
		return state;
	}

	public void setState(EntityStateAbstract state) {
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
