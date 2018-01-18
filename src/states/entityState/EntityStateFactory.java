package states.entityState;

import states.entityState.basicEntityStates.BasicEntityStateIdle;

/**
 * Class EntityStateFactory is the factory class for creating an instance of
 * a Entity State given a string.
 * 
 * The factory will default to BasicEntityStateIdle.
 */
public class EntityStateFactory {

	public EntityStateFactory() {}
	
	public EntityStateAbstract createState(EntityStateContext context, String stateName){
		switch (stateName) {
		case "Basic_Entity":
			return (new BasicEntityStateIdle(context));
		case "Basic_Null_Entity":
			return (new NoEntityState(context));
		default:
			return (new NoEntityState(context));
		}
	}
}
