import java.awt.Point;

/* Brief: Entity is an abstract class which is used
 * 		to be the foundation of any object, terrain,
 * 		character, or enemy.
 * 
 *  TODO: Find common data required
 */
public abstract class Entity {
	private Point point;
	
	public Entity(Point point) {
		this.point = point;
	}
}
