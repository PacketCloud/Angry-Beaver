package states.gameState;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;

import fileUtility.OpenImage;

public class GameStateHostSetup extends GameStateAbstract {
	private String hostSetupTitle = "CREATE A GAME";
	private ArrayList<String> hostSetupText = new ArrayList<String>(Arrays.asList("Port Number", "Create Lobby", "Back"));
	private int chosen = 0;	
	private Image background = null;
	
	private String address = "";
	private String port = "";
	
	public GameStateHostSetup(GameStateContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Host");
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		drawBackground(g);
		
		// TODO: Positioning of text based on the window size.
		// Set menu title
		Font font = new Font(titleFont, 0, titleSize);
		g.setFont(font);
		g.setColor(titleColor);
		
		g.drawString(hostSetupTitle, 290, 150);
		
		Font font1 = new Font(textFont, 0, textSize);
		g.setFont(font1);
		
		for (int i = 0; i < hostSetupText.size(); i++) {
			if(chosen == i) {
				g.setColor(selectColor);
			} else {
				g.setColor(defaultColor);
			}
			
			g.drawString(hostSetupText.get(i), 550, 300 + i * 100);
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
	public void up() {
		// TODO Auto-generated method stub
		super.up();
		
		chosen--;
		if (chosen < 0) {
			chosen = hostSetupText.size() - 1;
		}
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		super.down();
		
		chosen++;
		if (chosen >= hostSetupText.size()) {
			chosen = 0;
		}
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		super.jump();
		
		switch(chosen) {
		case 1:
			// context.setGameState(new GameStateHostLobby());
			break;
		case 2:
			context.setGameState(new GameStateMultiplayer(context));
		}
	}
	
	
}