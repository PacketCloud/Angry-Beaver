package engine;

import java.awt.Point;

//import entities.Entity;

public class LevelSettings {
	/* LevelSettings is used for setting the boundary of the Level, as well
	 * as introducing gravity to the game.
	 * 
	 * The assumption is that LeftBounds is less than RightBounds .
	 * TODO: There should be a default LevelSettings if no LevelSettings is
	 * 		specified.
	 * This class is current not used.
	 */
	private int rightBounds;
	private int leftBounds;
	private int botBounds;
	private int fallSpeed;
	public LevelSettings(int left, int right, int bot, int fallSpeed) {
		setRightBounds(right);
		setLeftBounds(left);
		setBotBounds(bot);
		setFallSpeed(fallSpeed);
	}

	public void setRightBounds(int rightBounds) {
		this.rightBounds = rightBounds;
	}
	
	public void setLeftBounds(int leftBounds) {
		this.leftBounds = leftBounds;
	}
	
	public void setBotBounds(int botBounds) {
		this.botBounds = botBounds;
	}
	
	public void setFallSpeed(int fallSpeed) {
		this.fallSpeed = fallSpeed;
	}
	
	public int getRightBounds() {
		return rightBounds;
	}

	public int getLeftBounds() {
		return leftBounds;
	}

	public int getBotBounds() {
		return botBounds;
	}
	
	public int getFallSpeed() {
		return fallSpeed;
	}
/*
	public void dropEntity(Entity entity) {
		Point pos = entity.getPosition();
		pos.translate(0, fallSpeed);
		
		entity.setPosition(checkBotBounds(pos));
	}
	
	public void checkBounds(Entity entity) {
		Point pos = entity.getPosition();
		pos = checkRightBounds(pos);
		pos = checkLeftBounds(pos);
		pos = checkBotBounds(pos);
		entity.setPosition(pos);
	}
*/
	public Point checkRightBounds(Point pos){
		if ((int) pos.getX() > rightBounds) {
			pos.setLocation(rightBounds, pos.getY());
		}
		return pos;
	}
	
	public Point checkLeftBounds(Point pos){
		if ((int) pos.getX() < leftBounds) {
			pos.setLocation(leftBounds, pos.getY());
		}
		return pos;
	}
	
	public Point checkBotBounds(Point pos){
		if ((int) pos.getY() > botBounds) {
			pos.setLocation(pos.getX(), botBounds);
		}
		return pos;
	}
}
