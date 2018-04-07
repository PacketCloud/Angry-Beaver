package behaviour;

import engine.Level;
import entities.AbstractEntity;

/**
 * Interface BehaviourInterface defines two required methods;
 * run() and doAction() for all behaviours.
 */
public interface BehaviourInterface {
	public void run(AbstractEntity entity, Level level);
	public void doAction(String action, AbstractEntity entity);
}
