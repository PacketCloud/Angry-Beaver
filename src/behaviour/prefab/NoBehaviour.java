package behaviour.prefab;

import behaviour.AbstractBehaviour;
import engine.Level;
import entities.AbstractEntity;

/**
 * Class NoBehaviour defines no behaviour.
 *
 * No actions are performed.
 */
public class NoBehaviour extends AbstractBehaviour {

	@Override
	public void run(AbstractEntity entity, Level level) {
		// Do nothing
	}
}
