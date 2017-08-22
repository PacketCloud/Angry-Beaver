package states.gameState;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import fileUtility.OpenImage;

public class GameStateExit extends GameStateAbstract {
	private String exitTitle = "The game will now exit";
	private Image background = null;
	
	public GameStateExit(GameStateContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Exit");
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
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
				//Image background = new ImageIcon(path + "/Resources/Textures/Background/Background_MountainHorizon.png").getImage();
				
			} catch (Exception e){
				System.out.println(e.toString());
			}
		}
		g.drawImage(background, 0, 0, 1920, 1080, null);
	}

	@Override
	public void userInput(String action) {
		// TODO Auto-generated method stub
		//super.userInput(action);
		
		context.setGameState(new GameStateStop(context));
	}
}
