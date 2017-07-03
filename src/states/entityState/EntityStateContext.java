package states.entityState;

import entities.Object;

public class EntityStateContext {
	public EntityStateAbstract state;
	public Object obj;
	
	public EntityStateContext(Object obj) {
		this.obj = obj;
		
	}
	
	public void initState() {
		
	}
	
	public void repaint() {
		
	}
}
