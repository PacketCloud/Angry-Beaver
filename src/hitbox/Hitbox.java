package hitbox;

import java.awt.Graphics2D;
import java.awt.Point;

public class Hitbox extends HitboxProperties{
	public Point position; // This is the position relative to the entity the Hitbox is associated with
	public int height;
	public int width;
	
	public Hitbox(Point position, int width, int height) {
		setPosition(position);
		setHeight(height);
		setWidth(width);
	}

	public Hitbox(int xPos, int yPos, int width, int height) {
		setPosition(new Point(xPos,yPos));
		setHeight(height);
		setWidth(width);
	}
	
	public Hitbox(int width, int height) {
		setPosition(new Point(0,0));
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
}
