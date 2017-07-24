package hitbox;

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
