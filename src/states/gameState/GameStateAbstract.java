package states.gameState;

import engine.LevelHandler;
import keyInputs.ACTIONS;

/*	All actions in the game should be defined here
 * 		The actions will be overridden and will be dealt 
 * 		with depending on the extended GameState.
 */

public abstract class GameStateAbstract implements GameStateInterface{
	private LevelHandler h;
	
	public GameStateAbstract(LevelHandler h) {
		this.h = h;
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
		case ACTIONS.R_MOVE_UP:
			r_up();
			break;
		case ACTIONS.R_MOVE_DOWN:
			r_down();
			break;
		case ACTIONS.R_MOVE_RIGHT:
			r_right();
			break;
		case ACTIONS.R_MOVE_LEFT:
			r_left();
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
		case ACTIONS.THROW:
			iThrow();
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
	
	public void r_up(){
		System.out.println("Up arrow key released");
	}
	public void r_down(){
		System.out.println("Down arrow key released");
	}
	public void r_right(){
		System.out.println("Right arrow key released");
	}
	public void r_left(){
		System.out.println("Left arrow key released");
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
	public void iThrow(){
		System.out.println("D key pressed (Throw log)");
	}

	public LevelHandler getH() {
		return h;
	}

	public void setH(LevelHandler h) {
		this.h = h;
	}

}
