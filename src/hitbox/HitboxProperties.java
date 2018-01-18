package hitbox;

/**
 * Class HitboxProperties is an abstract class for Hitboxes to determine
 * the type of Hitbox.
 * 
 * There are three types of hitboxes: Solid, Body, and Trigger.
 * Any Hitbox can be more than one type.
 * 
 * @see CollisionDetector class for the interactions between the types of Hitboxes 
 */
public abstract class HitboxProperties {
	private boolean isSolid = false;
	private boolean isBody = false;
	private boolean isTrigger = false;
	
	public boolean isSolid() {
		return isSolid;
	}
	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}
	public boolean isBody() {
		return isBody;
	}
	public void setBody(boolean isBody) {
		this.isBody = isBody;
	}
	public boolean isTrigger() {
		return isTrigger;
	}
	public void setTrigger(boolean isTrigger) {
		this.isTrigger = isTrigger;
	}
	
	
}
