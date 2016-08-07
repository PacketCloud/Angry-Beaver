package engine;

import java.awt.Point;

import entities.Entity;

public class LevelSettings {
	int rightBounds;
	int leftBounds;
	int botBounds;
	int fallSpeed;
	public LevelSettings(int right, int left, int bot, int fallSpeed) {
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
	
	public void dropEntity(Entity entity) {
		Point pos = entity.getPosition();
		//TODO:  
	}
}
