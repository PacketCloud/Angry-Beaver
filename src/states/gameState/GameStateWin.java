package states.gameState;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class GameStateWin is the Game State where the Player wins
 * when playing a level.
 * 
 * Win conditions may change depending on the level.
 */
public class GameStateWin extends GameStateAbstract {
	private String winTitle;
	private ArrayList<String> winText;
	private int chosen;
	
	public GameStateWin(GameStateContext context) {
		super(context);
		winTitle = "Level Complete";
		winText = new ArrayList<String>(Arrays.asList("Level Select", "Menu", "Exit"));
		chosen = 0;
	}

	@Override
	public void update() {
		System.out.println("Win");
	}

	@Override
	public void render(Graphics2D g) {
		g.setFont(new Font(titleFont, 0, titleSize));
		g.setColor(titleColor);
		g.drawString(winTitle, 290, 150);
		
		g.setFont(new Font(textFont, 0 ,textSize));
		
		int y = 300;
		for (int i = 0; i < winText.size(); i++) {
			if (chosen == i) {
				g.setColor(selectColor);
			} else {
				g.setColor(defaultColor);
			}
			g.drawString(winText.get(i), 550, y);
			y += 100;
		}
	}

	@Override
	public void up() {
		super.up();
		
		chosen--;
		if (chosen <0) {
			chosen = winText.size() - 1;
		}
	}

	@Override
	public void down() {
		super.down();
		
		chosen++;
		if (chosen >= winText.size()) {
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
