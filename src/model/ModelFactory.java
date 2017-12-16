package model;

public class ModelFactory {

	public AbstractModel createModel(String modelName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> cls = Class.forName("model.prefab." + modelName);
		AbstractModel model = (AbstractModel) cls.newInstance();
		return model;
	}
}
