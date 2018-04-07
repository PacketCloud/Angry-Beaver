package states.gameState;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class GameStateLose is the Game State for losing the game.
 * 
 * This state will occur when the Level being played does not have
 * an entity with the id of 'Player'
 */
public class GameStateLose extends GameStateAbstract {
	private String loseTitle;
	private ArrayList<String> loseText;
	private int chosen;
	
	public GameStateLose(GameStateContext context) {
		super(context);
		 loseTitle = "GAME OVER";
		 loseText = new ArrayList<String>(Arrays.asList("Level Select", "Menu", "Exit"));
		 chosen = 0;
	}

	@Override
	public void update() {
		System.out.println("Lose");
	}

	@Override
	public void render(Graphics2D g) {
		// Set losing text
		g.setFont(new Font(titleFont, 0, titleSize));
		g.setColor(titleColor);
		g.drawString(loseTitle, 290, 150);
		
		g.setFont(new Font(textFont, 0 ,textSize));
		
		int y = 300;
		for (int i = 0; i < loseText.size(); i++) {
			if (chosen == i) {
				g.setColor(selectColor);
			} else {
				g.setColor(defaultColor);
			}
			g.drawString(loseText.get(i), 550, y);
			y += 100;
		}
	}

	@Override
	public void up() {
		super.up();
		
		chosen--;
		if (chosen <0) {
			chosen = loseText.size() - 1;
		}
	}

	@Override
	public void down() {
		super.down();
		
		chosen++;
		if (chosen >= loseText.size()) {
			chosen = 0;
		}
	}

	@Override
	public void jump() {
		super.jump();
		
		switch(chosen) {
		case 0:
			context.setGameState(new GameStateLevelSelect(context));
			break;
		case 1:
			context.setGameState(new GameStateMenu(context));
			break;
		case 2:
			context.setGameState(new GameStateStop(context));
		}
	}
}
