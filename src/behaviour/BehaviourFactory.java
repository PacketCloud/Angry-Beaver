package behaviour;

public class BehaviourFactory {

	public AbstractBehaviour createBehaviour(String behaviourName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> cls = Class.forName("behaviour.prefab." + behaviourName);
		AbstractBehaviour behaviour = (AbstractBehaviour) cls.newInstance();
		return behaviour;
	}
}
