package engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entities.AbstractEntity;
import entities.Hitbox;

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
				if(e1 != e2) {
					
					// Get all hitboxes which collide with each other
					Map<Hitbox, Hitbox> collisions = collisions(e1, e2);

					if(!collisions.isEmpty()) {
						//collisionResponse(e1, e2);
						// Temporary code. Collision Handling should be used here 
						e1.getPosition().move(0, 0);
					}
				}
			}
		}
	}
	
	// Return all hitboxes which collide with each other
	public Map<Hitbox, Hitbox> collisions(AbstractEntity e1, AbstractEntity e2){
		// Get absolute hitboxes from both entities
		ArrayList<Hitbox> hitboxes1 = e1.getAbsHitboxes();
		ArrayList<Hitbox> hitboxes2 = e2.getAbsHitboxes();
		
		Map<Hitbox, Hitbox> collisions = new HashMap<Hitbox, Hitbox>();
		
		// Check if any hitboxes intersect with each other
		for(Hitbox h1 : hitboxes1) {
			for(Hitbox h2 : hitboxes2) {
				if(intersects(h1, h2)) {
					collisions.put(h1, h2);
				}
			}
		}
		
		return collisions;
	}
	
	// Detecting an intersection uses the Separating Axis Theorem.
	// This checks the distance between two hitboxes on the X axis and the Y axis
	public boolean intersects(Hitbox h1, Hitbox h2) {
		
		int xPos1 = (int) h1.getPosition().getX();
		int yPos1 = (int) h1.getPosition().getY();
		int width1 = h1.getWidth();
		int height1 = h1.getHeight();
		
		int xPos2 = (int) h2.getPosition().getX();
		int yPos2 = (int) h2.getPosition().getY();
		int width2 = h2.getWidth();
		int height2 = h2.getHeight();
		 
		boolean xTouches = checkSperatingAxis(xPos1, xPos1 + width1, xPos2, xPos2 + width2);
		boolean yTouches = checkSperatingAxis(yPos1, yPos1 + height1, yPos2, yPos2 + height2);

		return (xTouches && yTouches);
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
	
	// Not used
	public void collisionResponse(AbstractEntity e1, AbstractEntity e2) {
		e1.hasIntersected(e2);
	}
}
