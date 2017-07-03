package entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

import ResourceHandling.ResourceCollection;
import states.entityState.entityStateAbstract;

public abstract class Object {
	
	private ResourceCollection model;
	private int behaviour;
	private DevLevel level;
	//TODO: entityStateContext is required
	private entityStateAbstract state;
	
	private Point position;
	private int width;
	private int height;
	
	private String id;

	private boolean facingRight = true;
	private boolean isSolid;
	
	private int moveSpeed;
	
	
	public Object() {
		
	}
	
	public void update() {
		// From Behaviour;
	}
	
	public void draw(Graphics2D g) {
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
}
