package states.gameState;

import java.awt.Color;

import keyInputs.ACTIONS;

/*	All actions in the game should be defined here
 * 		The actions will be overridden and will be dealt 
 * 		with depending on the extended GameState.
 */

public abstract class GameStateAbstract implements GameStateInterface{
	protected GameStateContext context;
	
	// Standard text fonts, sizes, and colors
	protected String titleFont = "Arial";
	protected String textFont = "Comic Sans MS";
	protected int titleSize = 100;
	protected int textSize = 50;
	
	protected Color titleColor = Color.BLACK;
	protected Color defaultColor = Color.BLACK;
	protected Color selectColor = Color.RED;
	
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
		case ACTIONS.NUM_0:
			num0();
			break;
		case ACTIONS.NUM_1:
			num1();
			break;
		case ACTIONS.NUM_2:
			num2();
			break;
		case ACTIONS.NUM_3:
			num3();
			break;
		case ACTIONS.NUM_4:
			num4();
			break;
		case ACTIONS.NUM_5:
			num5();
			break;
		case ACTIONS.NUM_6:
			num6();
			break;
		case ACTIONS.NUM_7:
			num7();
			break;
		case ACTIONS.NUM_8:
			num8();
			break;
		case ACTIONS.NUM_9:
			num9();
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
		System.out.println("D key pressed (Attack2)");
	}
	
	public void num0() {
		System.out.println("0 key pressed");
	}

	public void num1() {
		System.out.println("1 key pressed");
	}

	public void num2() {
		System.out.println("2 key pressed");
	}

	public void num3() {
		System.out.println("3 key pressed");
	}

	public void num4() {
		System.out.println("4 key pressed");
	}

	public void num5() {
		System.out.println("5 key pressed");
	}

	public void num6() {
		System.out.println("6 key pressed");
	}

	public void num7() {
		System.out.println("7 key pressed");
	}

	public void num8() {
		System.out.println("8 key pressed");
	}

	public void num9() {
		System.out.println("9 key pressed");
	}
}
