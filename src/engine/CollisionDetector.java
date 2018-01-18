package engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entities.AbstractEntity;
import hitbox.Hitbox;
import trigger.Trigger;

/**
 * Class CollisionDetector checks for collisions between entities 
 * by comparing their respective hitboxes for intersections. 
 */

public class CollisionDetector {
	private Level level;
	
	public CollisionDetector(Level level) {
		super();
		this.level = level;
	}

	/**
	 * Method detectCollitions will check all entities against each 
	 * other and find hitboxes which intersect.
	 * If intersections exist, handle the collision depending on the 
	 * properties of the hitbox.
	 */
	public void detectCollisions() {
		for(AbstractEntity e1 : level.getEntities()) {
			for (AbstractEntity e2 : level.getEntities()) {
				if(e1 != e2) {	
					// Get all hitboxes which collide with each other
					Map<Hitbox, Hitbox> collisions = collisions(e1, e2);

					// Handle the collision
					if(!collisions.isEmpty()) {
						collisionResponse(e1, e2, collisions);
					}
				}
			}
		}
	}
	
	/**	 
	 * Method collisions returns a map of all hitboxes which intersect each other.
	 * 
	 * @param e1		Entity 1 to check hitboxes from
	 * @param e2		Entity 2 to check hitboxes from
	 * @return 			Map of all hitboxes which interect each other.
	 */
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
	
	/**
	 * Method intersects checks the distance between two hitboxes on 
	 * the X-axis and the Y-axis.
	 *  
	 * Detecting an intersection uses the Separating Axis Theorem.
	 * 
	 * @param h1		Hitbox 1 
	 * @param h2		Hitbox 2
	 * @return 			True if either distance on the X-axis or Y-axis is negative.
	 * 		   			False otherwise.
	 */
	public boolean intersects(Hitbox h1, Hitbox h2) {
		int xDistance = getXDistance(h1, h2);
		int yDistance = getYDistance(h1, h2);

		return (xDistance < 0 && yDistance < 0);
	}

	/**
	 * Method intersectsArea checks if an entity intersects with the given hitbox.
	 * 
	 * @param e			AbstractEntity
	 * @param hitbox 	hitbox to check if intersecting with the given entity
	 * @return 			True if the entity intersects the given hitbox.
	 * 					False otherwise.
	 */
	public boolean intersectsArea(AbstractEntity e, Hitbox hitbox) {
		ArrayList<Hitbox> hitboxes = e.getAbsHitboxes();
		for(Hitbox h : hitboxes) {
			if(intersects(h, hitbox)) {
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * Method getXDistance takes two hitboxes and returns the distance between the hitboxes
	 * on the X-axis.
	 * 
	 * @param h1		Hitbox 1
	 * @param h2 		Hitbox 2
	 * @return 			The distance separating hitbox 1 and hitbox 2 on the X-axis
	 */
	public int getXDistance(Hitbox h1, Hitbox h2) {
		int xPos1 = (int) h1.getPosition().getX();
		int width1 = h1.getWidth();
		
		int xPos2 = (int) h2.getPosition().getX();
		int width2 = h2.getWidth();
		return checkSperatingDistance(xPos1, xPos1 + width1, xPos2, xPos2 + width2);
	}

	/**
	 * Method getXDistance takes two hitboxes and returns the distance between the hitboxes
	 * on the Y-axis.
	 * 
	 * @param h1		Hitbox 1
	 * @param h2 		Hitbox 2
	 * 
	 * @return 			The distance separating hitbox 1 and hitbox 2 on the Y-axis
	 */
	public int getYDistance(Hitbox h1, Hitbox h2) {
		int yPos1 = (int) h1.getPosition().getY();
		int height1 = h1.getHeight();
		
		int yPos2 = (int) h2.getPosition().getY();
		int height2 = h2.getHeight();
		return checkSperatingDistance(yPos1, yPos1 + height1, yPos2, yPos2 + height2);
	}
	
	/**
	 * @param x1		integer of the left bound of hitbox 1
	 * @param x2		integer of the right bound of hitbox 1
	 * @param x3		integer of the left bound of hitbox 2
	 * @param x4		integer of the right bound of hitbox 2
	 * 
	 * @return			The distance between the two hitboxes
	 */
	public int checkSperatingDistance(int x1,int x2, int x3, int x4) {
		int distance = x4 - x1;
		if( x1 > x3) {
			distance = x2 - x3;
		}
		distance -= (x2 - x1);
		distance -= (x4 - x3);
		
		return distance;
	}
	
	/**
	 * Method collisionResponse handles the collision depending on the properties of the hitboxes which intersect
	 * 
	 * @param e1			Entity 1			
	 * @param e2			Entity 2
	 * @param collisions	A map of the hitboxes which intersect 
	 * 						between entity 1 and entity 2
	 */
	public void collisionResponse(AbstractEntity e1, AbstractEntity e2, Map<Hitbox, Hitbox> collisions) {
		
		for(Map.Entry<Hitbox, Hitbox> overlap : collisions.entrySet() ) {
			Hitbox h1 = overlap.getKey();
		    Hitbox h2 = overlap.getValue();
		    
		    // e1 touches a trigger from e2
		    if(h1.isBody() && h2.isTrigger()) {
		    	// e1.isTriggeredBy(e2);
		    	Trigger trigger = e2.getTrigger();
		    	if(trigger != null) {
		    		trigger.triggerEffects(e1, e2);
		    	}
		    }

		    // e2 touches a trigger from e1
		    if(h2.isBody() && h1.isTrigger()) {
		    	// e2.isTriggeredBy(e1);
		    	Trigger trigger = e1.getTrigger();
		    	if(trigger != null) {
		    		trigger.triggerEffects(e2, e1);
		    	}
		    }
		    
		    
		    // If the hitboxes are both solid, correct the positioning of the entity
		    // If one hitbox is a body and the other is a solid, correct the positioning of the entity
		    if((h1.isSolid() && h2.isSolid()) || (h1.isBody() && h2.isSolid()) || (h1.isSolid() && h2.isBody())) {
		    	System.out.println("Solid Collision Detected");
		    	
		    	if(e1.isStatic() && e2.isStatic()) {
		    		// Both entities can not move, ignore?
		    		System.out.println("Both static");
		    		
		    	} else if (e1.isStatic()) {
		    		// e1 can not move but e2 can move
		    		// Check by how much e2 intersects e1, and then move e2 away from e1 that distance
		    		System.out.println("e1 static");
		    		
		    		//TODO: Code cleanup
		    		int x = getXDistance(h1, h2);
		    		int y = getYDistance(h1, h2);
		    		
		    		// If the hitboxes intersect on the x-axis more than the y-axis
		    		if(x > y) {
		    			if(h1.getPosition().x > h2.getPosition().x) {
		    				e2.translate(x, 0);
		    			} else {
		    				e2.translate(-x, 0);
		    			}
		    		
		    		// If the hitboxes intersect on the y-axis more than the x-axis
		    		} else {
		    			if(h1.getPosition().y > h2.getPosition().y) {
		    				e2.translate(0, y);
		    			} else {
		    				e2.translate(0, -y);
		    			}
		    		}

		    	} else if (e2.isStatic()) {
		    		// e2 can not move but e1 can move
		    		// Check by how much e1 intersects e2, and then move e1 away from e2 that distance
		    		System.out.println("e2 static");
		    		
		    		//TODO: Code cleanup
		    		int x = getXDistance(h1, h2);
		    		int y = getYDistance(h1, h2);
		    		
		    		// If the hitboxes intersect on the x-axis more than the y-axis
		    		if(x > y) {
		    			if(h1.getPosition().x > h2.getPosition().x) {
		    				e1.translate(-x, 0);
		    			} else {
		    				e1.translate(x, 0);
		    			}
		    			
			    	// If the hitboxes intersect on the y-axis more than the x-axis
		    		} else {
		    			if(h1.getPosition().y > h2.getPosition().y) {
		    				e1.translate(0, -y);
		    			} else {
		    				e1.translate(0, y);
		    			}
		    		}
		    	} else {
		    		// Allow entities to push each other since both can be moved
		    		// Check by how much the entities intersect, and then move both entities away from each other half that distance
		    		System.out.println("None static");
		    		
		    		//TODO: Code cleanup
		    		int x = getXDistance(h1, h2);
		    		int y = getYDistance(h1, h2);
		    		// If the hitboxes intersect on the x-axis more than the y-axis
		    		if(x > y) {
		    			if(h1.getPosition().x > h2.getPosition().x) {
		    				e1.translate(-x/2, 0);
		    				e2.translate(x/2, 0);
		    			} else {
		    				e1.translate(x/2, 0);
		    				e2.translate(-x/2, 0);
		    			}

		    		// If the hitboxes intersect on the y-axis more than the x-axis
		    		} else {
		    			if(h1.getPosition().y > h2.getPosition().y) {
		    				e1.translate(0, -y/2);
		    				e2.translate(0, y/2);
		    			} else {
		    				e1.translate(0, y/2);
		    				e2.translate(0, -y/2);
		    			}
		    		}
		    	}
		    }
		}
	}
}
