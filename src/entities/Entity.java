package entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import ResourceHandling.ResourceCollection;

/* Currently not in use*/

public class Entity implements EntityInterface {
	private Point Position;
	private Hitbox Hitbox;
	private ResourceCollection Model;
	private String EntityState;
	private int Facing = 1;
		
	public Entity(Point position, Hitbox hitbox, ResourceCollection model, int facing, String entityState) {
		super();
		Position = position;
		setHitbox(hitbox);
		Model = model;
		EntityState = entityState;
		setFacing(facing);
	}

	public void update() {
		updateHitbox();
	}
	
	public void updateHitbox() {
		Hitbox.setPosition(Position);//TODO: Make sure hitbox is updated directly after position updates, to make sure hitbox does not lag behind entity.
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
	
	public void translate(int x, int y) {
		Position.translate(x, y);
	}
	
	/******** Getters and Setters ********/
	public Hitbox getHitbox() {
		return Hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		Hitbox = hitbox;
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
