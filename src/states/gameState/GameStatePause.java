package states.gameState;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;

import engine.Level;

public class GameStatePause extends GameStateAbstract {
	private String pauseTitle = "GAME PAUSED";
	private ArrayList<String> pauseText = new ArrayList<String>(Arrays.asList("Resume", "Options", "Menu", "Exit"));
	private int chosen = 0;	
	
	private Level pausedLevel;
	
	public GameStatePause(GameStateContext context, Level level) {
		super(context);
		this.pausedLevel = level;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		//context.repaint();
    	System.out.println("Paused");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		super.pause();
		context.setGameState(new GameStateRun(context, pausedLevel));
		//getH().getGameState().stateRun();
	}

	@Override
	public void render(Graphics2D g) {		
		// TODO Location of the text should depend on the window size
		
		// Set pause title
		g.setFont(new Font(titleFont, 0, titleSize));
		g.setColor(titleColor);
		g.drawString(pauseTitle, 290, 150);
		
		// Set selection text
		g.setFont(new Font(textFont, 0, textSize));
		
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
			context.setGameState(new GameStateRun(context, pausedLevel));
			break;
		case 1:
			context.setGameState(new GameStateOption(context));
			break;
		case 2:
			context.setGameState(new GameStateMenu(context));
			break;
		case 3:
			context.setGameState(new GameStateStop(context));
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
