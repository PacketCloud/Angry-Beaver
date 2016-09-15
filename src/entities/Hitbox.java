package entities;

import java.awt.Point;

public class Hitbox {
	Point position;
	int height;
	int width;
	
	public Hitbox(Point position, int height, int width) {
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
		//if(this.getPosition().getX() < pHitbox.)
		return false;
	}
}
