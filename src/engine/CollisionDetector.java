package engine;

import entities.AbstractEntity;

public class CollisionDetector {
	
	private Level level;
	
	public CollisionDetector(Level level) {
		super();
		this.level = level;
	}

	public void detectCollisions() {
		// Loop all entities against each other
		for(AbstractEntity e1 : level.getEntities()) {
			for (AbstractEntity e2 : level.getEntities()) {
				if(e1 != e2 && intersects(e1, e2)) {
					collisionResponse(e1, e2);
				}
			}
		}
	}
	
	public boolean intersects(AbstractEntity e1, AbstractEntity e2) {
		/*
			Temporary until Hitboxes are implemented
		 
		int xPos1 = (int) e1.getPosition().getX();
		int yPos1 = (int) e1.getPosition().getY();
		int width1 = e1.getWidth();
		int height1 = e1.getHeight();
		
		int xPos2 = (int) e2.getPosition().getX();
		int yPos2 = (int) e2.getPosition().getY();
		int width2 = e2.getWidth();
		int height2 = e2.getHeight();
		
		// Detecting an intersection uses the Separating Axis Theorem.
		// This checks the distance between two entities on the X axis and the Y axis 
		boolean xTouches = checkSperatingAxis(xPos1, xPos1 + width1, xPos2, xPos2 + width2);
		boolean yTouches = checkSperatingAxis(yPos1, yPos1 + height1, yPos2, yPos2 + height2);

		return (xTouches && yTouches);*/
		return false;
	}
	
	
	public boolean checkSperatingAxis(int x1,int x2, int x3, int x4) {
		int distance = x4 - x1;
		if( x1 > x3) {
			distance = x2 - x3;
		}
		distance -= (x2 - x1);
		distance -= (x4 - x3);
		
		return (distance < 0);
	}
	
	public void collisionResponse(AbstractEntity e1, AbstractEntity e2) {
		e1.hasIntersected(e2);
	}
}
