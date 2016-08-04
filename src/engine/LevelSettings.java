package engine;

public class LevelSettings {
	int rightBounds;
	int leftBounds;
	int botBounds;
	
	public LevelSettings(int right, int left, int bot) {
		setRightBounds(right);
		setLeftBounds(left);
		setBotBounds(bot);
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
	
	public int getRightBounds() {
		return rightBounds;
	}

	public int getLeftBounds() {
		return leftBounds;
	}

	public int getBotBounds() {
		return botBounds;
	}
	
}
