package states.entityState;

/**
 * Class EntityStateAbstract is an abstract class for all Entity States.
 * Entity States determine the result of an action when performed.
 */
public abstract class EntityStateAbstract implements EntityStateInterface {
	protected EntityStateContext context;
	
	public EntityStateAbstract(EntityStateContext context) {
		this.context = context;
	}

	public void up() { }

	public void down() { }

	public void right() { }

	public void left() { }

	public void pause() { }

	public void jump() { }
	
	public void attack() {	}

	public void attack2() { }
}
