package entities;

import java.awt.Point;

import behaviour.BehaviourFactory;
import hitbox.Hitbox;
import hitbox.HitboxFactory;
import model.ModelFactory;
import states.entityState.EntityStateContext;
import trigger.TriggerFactory;

/**
 * Class EntityFactory is a factory class for creating entities from a given String
 */

public class EntityFactory {

	/** 
	 * Method createEntity will take in a string of the entity class and a string of parameters.
	 * It will return an instance of the entity with the defined parameters.
	 * 
	 * @param entityName				String of the entity class name
	 * @param parameters				String of parameters to set the entity to
	 * @return							Returns a entity object
	 */
	public AbstractEntity createEntity(String entityName, String parameters) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
				
		Class<?> cls = Class.forName("entities.prefab." + entityName);
		AbstractEntity entity = (AbstractEntity) cls.newInstance();
		
		String[] parameter = parameters.split(" ");
		for (String param : parameter) {
			String[] split = param.split(":");
			setParameter(entity, split[0], split[1]);
		}
		return entity;
	}
	
	/**
	 * Method setParamter will set variables of the entity to the given values
	 * 
	 * @param entity			The entity to set the parameter to
	 * @param type				A string of the type of parameter to set
	 * @param value				A string of the value to set the parameter to
	 */
	public void setParameter(AbstractEntity entity, String type, String value) {
		switch (type) {
			case "Position":
				String[] parse = value.split(",",2);
				entity.setPosition(new Point(Integer.parseInt(parse[0]), Integer.parseInt(parse[1])));
				break;
			case "Scaling":
				entity.setScaling(Double.parseDouble(value));
				break;
			case "Health":
				entity.setHealth(Integer.parseInt(value));
				break;
			case "Damage":
				entity.setDamage(Integer.parseInt(value));
				break;
			case "MoveSpeed":
				entity.setMoveSpeedX(Integer.parseInt(value));
				break;
			case "JumpHeight":
				entity.setJumpStrength(Integer.parseInt(value));
				break;
			case "Trigger":
				entity.setTrigger(new TriggerFactory().createTrigger(value));
				break;
			case "Model":
				try {
					entity.setModel(new ModelFactory().createModel(value));
				} catch (Exception e) {
					System.out.println("Model " + value + " could not be found");
				}
				break;
			case "Behaviour":
				try {
					entity.setBehaviour(new BehaviourFactory().createBehaviour(value));
				} catch (Exception e) {
					System.out.println("Behaviour " + value + " could not be found");
				}
				break;
			case "State":
				entity.setState(new EntityStateContext(entity, value));
				break;
			case "ID":
				entity.setId(value);
				break;
			case "Facing":
				entity.setFacingRight(Boolean.parseBoolean(value));
				break;
			case "Static":
				entity.setStatic(Boolean.parseBoolean(value));
				break;
			case "Invulnerable":
				entity.setInvulnerable(Boolean.parseBoolean(value));
				break;
			case "Hitbox":
				Hitbox h = new HitboxFactory().createHitbox(value);
				
				entity.addHitbox(h);
				break;
			default:
				
		}
	}
}
