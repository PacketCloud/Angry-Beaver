package entities;

import java.awt.Point;

public class Hitbox {
	Point position;
	int height;
	int width;
	
	public Hitbox(Point position, int width, int height) {
		setPosition(position);
		setHeight(height);
		setWidth(width);
	}
	
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public Boolean intersects(Platform platform) {
		//Hitbox pHitbox = platform.getHitbox();
		return false;
	}
	
	//TODO: These functions.
	public Boolean intersectAbove(Hitbox hitbox) {
		return false;
	}
	
	public Boolean intersectBelow(Hitbox hitbox) {
		return false;
	}
	
	public Boolean intersectRight(Hitbox hitbox) {
		return false;
	}
	
	public Boolean intersectLeft(Hitbox hitbox) {
		return false;
	}
}
