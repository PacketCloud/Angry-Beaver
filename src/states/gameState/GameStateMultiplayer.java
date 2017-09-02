package states.gameState;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;

import fileUtility.OpenImage;

public class GameStateMultiplayer extends GameStateAbstract {
	private String multiplayerTitle = "ANGRY BEAVER MULTIPLAYER";
	private ArrayList<String> multiplayerText  = new ArrayList<String>(Arrays.asList("Create Game", "Join Game","Back"));
	private int chosen = 0;	
	private Image background = null;
	
	public GameStateMultiplayer(GameStateContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Multiplayer Menu");
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		drawBackground(g);
		
		Font font = new Font(titleFont, 0, titleSize);
		g.setFont(font);
		g.setColor(titleColor);
		
		g.drawString(multiplayerTitle, 290, 150);
		
		// Set selection text
		Font font1 = new Font(textFont, 0, textSize);
		g.setFont(font1);
		
		for(int i = 0; i < multiplayerText.size(); i++) {
			if(chosen == i) {
				g.setColor(selectColor);
			} else {
				g.setColor(defaultColor);
			}
			g.drawString(multiplayerText.get(i), 550, 300 + i * 100);
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
		// TODO Auto-generated method stub
		super.jump();
		switch(chosen) {
		case 0:
			context.setGameState(new GameStateHostSetup(context));
			break;
		case 1:
			//context.setGameState(new GameStateJoin(context));
			break;
		case 2:
			context.setGameState(new GameStateMenu(context));
		}
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		super.up();

		chosen--;
		if (chosen < 0) {
			chosen = multiplayerText.size() - 1;
		}
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		super.down();

		chosen++;
		if (chosen >= multiplayerText.size()) {
			chosen = 0;
		}
	}
}
