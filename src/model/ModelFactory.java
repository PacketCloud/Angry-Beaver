package model;

/**
 * Class ModelFactory is a factory class for creating models given the 
 * model name.
 *
 */
public class ModelFactory {

	/**
	 * Method createModel creates an instance of a model given the model name
	 * 
	 * @param modelName						String of the model name
	 * @return								An instance of the model
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public AbstractModel createModel(String modelName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> cls = Class.forName("model.prefab." + modelName);
		AbstractModel model = (AbstractModel) cls.newInstance();
		return model;
	}
}
