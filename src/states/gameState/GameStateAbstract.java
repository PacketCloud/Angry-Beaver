package states.gameState;

import java.awt.Graphics2D;

import engine.LevelHandler;
import keyInputs.ACTIONS;

/*	All actions in the game should be defined here
 * 		The actions will be overridden and will be dealt 
 * 		with depending on the extended GameState.
 */

public abstract class GameStateAbstract implements GameStateInterface{
	public void userInput(LevelHandler h, String action) {
		switch (action) {
		case ACTIONS.MOVE_UP:
			up(h);
			break;
		case ACTIONS.MOVE_DOWN:
			down(h);
			break;
		case ACTIONS.MOVE_RIGHT:
			right(h);
			break;
		case ACTIONS.MOVE_LEFT:
			left(h);
			break;
		case ACTIONS.R_MOVE_UP:
			r_up(h);
			break;
		case ACTIONS.R_MOVE_DOWN:
			r_down(h);
			break;
		case ACTIONS.R_MOVE_RIGHT:
			r_right(h);
			break;
		case ACTIONS.R_MOVE_LEFT:
			r_left(h);
			break;
		case ACTIONS.PAUSE:
			pause(h);
			break;
		case ACTIONS.JUMP:
			jump(h);
			break;
		case ACTIONS.ATTACK:
			attack(h);
			break;
		case ACTIONS.THROW:
			iThrow(h);
			break;
		}
	}
	
	public void up(LevelHandler h){
		System.out.println("Up arrow key pressed");
	}
	public void down(LevelHandler h){
		System.out.println("Down arrow key pressed");
	}
	public void right(LevelHandler h){
		System.out.println("Right arrow key pressed");
	}
	public void left(LevelHandler h){
		System.out.println("Left arrow key pressed");
	}
	
	public void r_up(LevelHandler h){
		System.out.println("Up arrow key released");
	}
	public void r_down(LevelHandler h){
		System.out.println("Down arrow key released");
	}
	public void r_right(LevelHandler h){
		System.out.println("Right arrow key released");
	}
	public void r_left(LevelHandler h){
		System.out.println("Left arrow key released");
	}
	public void pause(LevelHandler h){
		System.out.println("Escape key pressed");
	}
	public void jump(LevelHandler h){
		System.out.println("Spacebar pressed");
	}
	public void attack(LevelHandler h){
		System.out.println("S key pressed (Attack)");
	}
	public void iThrow(LevelHandler h){
		System.out.println("D key pressed (Throw log)");
	}

}
