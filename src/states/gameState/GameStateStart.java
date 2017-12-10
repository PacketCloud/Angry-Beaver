package states.gameState;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Font;

import fileUtility.OpenImage;

public class GameStateStart extends GameStateAbstract {
	private String startText = "PRESS ANY KEY TO START";
	private Image background = null;
	
	public GameStateStart(GameStateContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		//context.repaint();
    	System.out.println("Start");
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
		drawBackground(g);
		// TODO: Positioning of text based on the window size.
		
		Font font = new Font(titleFont, 0, titleSize);
		g.setFont(font);
		g.setColor(titleColor);
		
		g.drawString(startText, 290, 150);
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
		
		context.setGameState(new GameStateMenu(context));
	}
}