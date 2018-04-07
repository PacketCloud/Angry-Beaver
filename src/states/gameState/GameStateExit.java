package states.gameState;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import fileUtility.OpenImage;

/**
 * Class GameStateExit is the Game State to confirm exiting the game.
 */
public class GameStateExit extends GameStateAbstract {
	private String exitTitle = "The game will now exit";
	private Image background = null;
	
	public GameStateExit(GameStateContext context) {
		super(context);
	}

	@Override
	public void update() {
		System.out.println("Exit");
	}

	@Override
	public void render(Graphics2D g) {
		drawBackground(g);
		// TODO: Positioning of text based on the window size.
		// Set exit title
		Font font = new Font(titleFont, 0, titleSize);
		g.setFont(font);
		g.setColor(titleColor);
		
		g.drawString(exitTitle, 290, 150);
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
	public void userInput(String action) {		
		context.setGameState(new GameStateStop(context));
	}
}
