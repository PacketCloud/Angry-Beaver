package engine;

import java.awt.Point;
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
						collisionResponse(e1, e2, collisions);
						// Temporary code. Collision Handling should be used here 
						//e1.getPosition().move(0, 0);
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
		int xDistance = getXDistance(h1, h2);
		int yDistance = getYDistance(h1, h2);

		System.out.println(xDistance);
		System.out.println(yDistance);
		return (xDistance < 0 && yDistance < 0);
	}

	public int getXDistance(Hitbox h1, Hitbox h2) {
		int xPos1 = (int) h1.getPosition().getX();
		int width1 = h1.getWidth();
		
		int xPos2 = (int) h2.getPosition().getX();
		int width2 = h2.getWidth();
		return checkSperatingDistance(xPos1, xPos1 + width1, xPos2, xPos2 + width2);
	}
	
	public int getYDistance(Hitbox h1, Hitbox h2) {
		int yPos1 = (int) h1.getPosition().getY();
		int height1 = h1.getHeight();
		
		int yPos2 = (int) h2.getPosition().getY();
		int height2 = h2.getHeight();
		return checkSperatingDistance(yPos1, yPos1 + height1, yPos2, yPos2 + height2);
	}
	
	public int checkSperatingDistance(int x1,int x2, int x3, int x4) {
		int distance = x4 - x1;
		if( x1 > x3) {
			distance = x2 - x3;
		}
		distance -= (x2 - x1);
		distance -= (x4 - x3);
		
		return distance;
	}
	
	public void collisionResponse(AbstractEntity e1, AbstractEntity e2, Map<Hitbox, Hitbox> collisions) {
		
		for(Map.Entry<Hitbox, Hitbox> overlap : collisions.entrySet() ) {
			Hitbox h1 = overlap.getKey();
		    Hitbox h2 = overlap.getValue();
		    
		    // if(h1.isAttack && h2.isBody) { }	e1 attacks e2
		    // if(h2.isAttack && h1.isBody) { }	e2 attacks e1
		    
		    // Solid hitboxes should not intersect
		    if(h1.isSolid && h2.isSolid) {
		    	System.out.println("Solid Collision Detected");
		    	
		    	if(e1.isStatic() && e2.isStatic()) {
		    		// Both entities can not move, ignore?
		    		System.out.println("Both static");
		    		
		    	} else if (e1.isStatic()) {
		    		// e1 can not move but e2 can move
		    		System.out.println("e1 static");

		    	} else if (e2.isStatic()) {
		    		// e2 can not move but e1 can move
		    		System.out.println("e2 static");
		    		
		    	} else {
		    		// Both entities can move
		    		System.out.println("None static");
		    	}
		    }
		}
	}
}
