package states.gameState;

import java.awt.Graphics2D;

import java.awt.Color;
import java.awt.Font;

import engine.LevelHandler;

public class GameStateStart extends GameStateAbstract {
	private String startText = "PRESS ANY KEY TO START";
	
	private Color defaultColor = Color.BLACK;
	public GameStateStart(LevelHandler h) {
		super(h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		getH().repaint();
    	System.out.println("Start");
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
		// TODO: Menu background?
		// TODO: Positioning of text based on the window size.
		
		Font font = new Font("Arial", 0, 55);
		g.setFont(font);
		g.setColor(defaultColor);
		
		g.drawString(startText, 290, 150);
	}

	@Override
	public void userInput(String action) {
		// TODO Auto-generated method stub
		//super.userInput(action);
		
		getH().getGameState().stateMenu();
	}
}