package states.entityState;

public interface EntityStateInterface {
	
	public void up();
	public void down();
	public void right();
	public void left();
	
	public void pause();
	public void jump();
	public void attack();
	public void attack2();
	
	public void checkForNextState();
	
	public String stateToString();
}
