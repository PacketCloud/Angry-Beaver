package entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import ResourceHandling.ResourceCollection;

public class Entity implements EntityInterface {
	private Point Position;
	private Hitbox hitbox;
	private ResourceCollection Model;
	private String EntityState;
	private int Facing = 1;
		
	public Entity(Point position, Hitbox hitbox, ResourceCollection model, int facing, String entityState) {
		super();
		Position = position;
		this.hitbox = hitbox;
		Model = model;
		EntityState = entityState;
		setFacing(facing);
	}

	public void update() {
	}
	
	public void draw(Graphics2D g) {
		Image texture = Model.getImageIcon(EntityState);
		float textureScale = Model.getImageScale(EntityState);
		g.drawImage(texture,//image to draw.
				(int) (Position.getX() + (-0.5 * getFacing() + 0.5) * texture.getWidth(null) * textureScale),//x position to draw, dependent on direction facing and scale.
				(int) Position.getY(),//y position to draw.
				(int) (texture.getWidth(null) * textureScale * getFacing()),//dx position to draw, dependent on direction facing and scale.
				(int) (texture.getHeight(null) * textureScale),//dy position to draw, dependent on scale.
				null);//observer, null.
	}
	
	public void hit() {
	}
	
	/******** Getters and Setters ********/
	public Hitbox getHitbox() {
		return hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}

	public ResourceCollection getModel() {
		return Model;
	}

	public void setModel(ResourceCollection model) {
		Model = model;
	}

	public String getEntityState() {
		return EntityState;
	}

	public void setEntityState(String entityState) {
		EntityState = entityState;
	}

	public void setPosition(Point newPosition) {
		this.Position = newPosition;
	}
	
	public Point getPosition() {
		return this.Position;
	}
	
	public void setFacing(int facing) {
		if (facing == -1) {
			Facing = facing;
			return;
		}
		Facing = 1;
		return;
	}
	
	public int getFacing() {
		return Facing;
	}
}
