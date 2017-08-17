package behaviour;

import engine.Level;
import entities.AbstractEntity;

public interface BehaviourInterface {
	//Empty definition for now, so implementing classes do not complain.
	
	//TODO: Define Behavior interface, then implement in subclasses.
	public void run(AbstractEntity entity, Level level);
	public void doAction(String action, AbstractEntity entity);
}
