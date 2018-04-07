package behaviour;

/**
 * BehaviourFactory is a factory class to create behaviour prefabs. 
 */

public class BehaviourFactory {

	/**
	 * Method createBehaviour will find and create a class of the given behaviour name.
	 * 
	 * @param behaviourName 	A string of the behaviour class to create
	 * @return					An instance of a behaviour class
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException 
	 */
	public AbstractBehaviour createBehaviour(String behaviourName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> cls = Class.forName("behaviour.prefab." + behaviourName);
		AbstractBehaviour behaviour = (AbstractBehaviour) cls.newInstance();
		return behaviour;
	}
}
