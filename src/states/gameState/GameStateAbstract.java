package states.gameState;

import engine.GameHandler;
import keyInputs.ACTIONS;

/*	All actions in the game should be defined here
 * 		The actions will be overridden and will be dealt 
 * 		with depending on the extended GameState.
 */

public abstract class GameStateAbstract implements GameStateInterface{
	protected GameStateContext context;
	
	public GameStateAbstract(GameStateContext context) {
		this.context = context;
	}

	public void userInput(String action) {
		switch (action) {
		case ACTIONS.MOVE_UP:
			up();
			break;
		case ACTIONS.MOVE_DOWN:
			down();
			break;
		case ACTIONS.MOVE_RIGHT:
			right();
			break;
		case ACTIONS.MOVE_LEFT:
			left();
			break;
		case ACTIONS.PAUSE:
			pause();
			break;
		case ACTIONS.JUMP:
			jump();
			break;
		case ACTIONS.ATTACK:
			attack();
			break;
		case ACTIONS.ATTACK2:
			attack2();
			break;
		}
	}
	
	public void up(){
		System.out.println("Up arrow key pressed");
	}
	public void down(){
		System.out.println("Down arrow key pressed");
	}
	public void right(){
		System.out.println("Right arrow key pressed");
	}
	public void left(){
		System.out.println("Left arrow key pressed");
	}
	
	public void pause(){
		System.out.println("Escape key pressed");
	}
	public void jump(){
		System.out.println("Spacebar pressed");
	}
	public void attack(){
		System.out.println("S key pressed (Attack)");
	}
	public void attack2(){
		System.out.println("D key pressed (Throw log)");
	}
}
