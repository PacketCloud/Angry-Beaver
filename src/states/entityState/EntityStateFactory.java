package states.entityState;

import states.entityState.basicEntityStates.*;
import states.entityState.lodgeStates.*;

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
		case "Lodge_State_1":
			return (new LodgeState1(context));
		case "Lodge_State_Complete":
			return (new LodgeStateComplete(context));
		default:
			return (new NoEntityState(context));
		}
	}
}
