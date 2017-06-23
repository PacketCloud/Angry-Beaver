package states.gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;

import engine.LevelHandler;

public class GameStatePause extends GameStateAbstract {
	private String pauseTitle = "GAME PAUSED";
	private ArrayList<String> pauseText = new ArrayList<String>(Arrays.asList("Resume", "Options", "Menu", "Exit"));
	private int chosen = 0;	
	
	private Color titleColor = Color.BLACK;
	private Color defaultColor = Color.BLACK;
	private Color selectColor = Color.RED;
	
	public GameStatePause(LevelHandler h) {
		super(h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		getH().repaint();
    	System.out.println("Paused");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		super.pause();
		getH().getGameState().stateRun();
	}

	@Override
	public void render(Graphics2D g) {
		
		Font font = new Font("Arial", 0, 100);
		g.setFont(font);
		g.setColor(titleColor);
		
		g.drawString(pauseTitle, 290, 150);
		
		// Set menu text
		Font font1 = new Font("Comic Sans MS", 0, 50);
		g.setFont(font1);
		
		int y = 300;
		for (int i = 0; i < pauseText.size(); i++) {
			if (chosen == i) {
				g.setColor(selectColor);
			} else {
				g.setColor(defaultColor);
			}
			g.drawString(pauseText.get(i), 550, y);
			y += 100;
		}
	}
	
	@Override
	public void jump() {
		// TODO Auto-generated method stub
		super.jump();
		switch(chosen) {
		case 0:
			getH().getGameState().stateRun();
			break;
		case 1:
			break;
		case 2:
			getH().getGameState().stateMenu();
			break;
		case 3:
			getH().getGameState().stateStop();
		}
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		super.up();
		
		chosen--;
		if (chosen < 0) {
			chosen = pauseText.size() - 1;
		}
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		super.down();
		
		chosen++;
		if (chosen >= pauseText.size()) {
			chosen = 0;
		}
	}
}
