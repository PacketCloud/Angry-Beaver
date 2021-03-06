package states.gameState;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;

import fileUtility.OpenImage;
import fileUtility.OpenSoundFile;

/**
 * Class GameStateMenu is the Game State where the main menu can be
 * accessed.
 */
public class GameStateMenu extends GameStateAbstract {
	private String menuTitle = "ANGRY BEAVER";
	private ArrayList<String> menuText  = new ArrayList<String>(Arrays.asList("Play", "Options","Exit"));
	private int chosen = 0;	
	private Image background = null;
	
	public GameStateMenu(GameStateContext context) {
		super(context);
	}

	@Override
	public void update() {
    	System.out.println("Menu");
	}

	@Override
	public void render(Graphics2D g) {
		drawBackground(g);
		
		// TODO: Positioning of text based on the window size.
		// Set menu title
		Font font = new Font(titleFont, 0, titleSize);
		g.setFont(font);
		g.setColor(titleColor);
		
		g.drawString(menuTitle, 290, 150);
		
		// Set selection text
		Font font1 = new Font(textFont, 0, textSize);
		g.setFont(font1);
		
		int y = 300;
		for (int i = 0; i < menuText.size(); i++) {
			if (chosen == i) {
				g.setColor(selectColor);
			} else {
				g.setColor(defaultColor);
			}
			g.drawString(menuText.get(i), 550, y);
			y += 100;
		}
	}
 
	public void drawBackground(Graphics2D g) {
		if(background == null) {
			try {
				background = new OpenImage().Open("/Resources/Textures/Background/Background_MountainHorizon.png");
				
			} catch (Exception e){
				System.out.println(e.toString());
			}
		}
		g.drawImage(background, 0, 0, 1920, 1080, null);
	}
	
	@Override
	public void jump() {
		super.jump();
		switch(chosen) {
		case 0:
			context.setGameState(new GameStateLevelSelect(context));
			break;
		case 1:
			context.setGameState(new GameStateOption(context));
			break;
		case 2:
			context.setGameState(new GameStateStop(context));
		}
	}

	@Override
	public void up() {
		super.up();
		
		// Example of sound usage
		new OpenSoundFile("/Resources/Audio/Woosh.wav").playSound();
		
		chosen--;
		if (chosen < 0) {
			chosen = menuText.size() - 1;
		}
	}

	@Override
	public void down() {
		super.down();
		
		// Example of sound usage
		new OpenSoundFile("/Resources/Audio/Woosh.wav").playSound();
		
		chosen++;
		if (chosen >= menuText.size()) {
			chosen = 0;
		}
	}
}
