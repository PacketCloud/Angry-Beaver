package states.gameState;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;

import fileUtility.OpenImage;

public class GameStateHostSetup extends GameStateAbstract {
	private String hostSetupTitle = "CREATE A GAME LOBBY";
	private ArrayList<String> hostSetupText = new ArrayList<String>(Arrays.asList("Port Number :", "Create Lobby!", "Back"));
	private int chosen = 0;	
	private Image background = null;
	
	private String port;
	
	public GameStateHostSetup(GameStateContext context) {
		super(context);
		// TODO Auto-generated constructor stub
		 port = "";
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Host Setup");
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
		
		g.drawString(port, 900, 300);
		
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
			context.setGameState(new GameStateHostLobby(context, port));
			break;
		case 2:
			context.setGameState(new GameStateMultiplayer(context));
		}
	}

	@Override
	public void num0() {
		// TODO Auto-generated method stub
		super.num0();
		if(chosen == 0) {
			port += "0";
		}
	}

	@Override
	public void num1() {
		// TODO Auto-generated method stub
		super.num1();
		if(chosen == 0) {
			port += "1";
		}
	}

	@Override
	public void num2() {
		// TODO Auto-generated method stub
		super.num2();
		if(chosen == 0) {
			port += "2";
		}
	}

	@Override
	public void num3() {
		// TODO Auto-generated method stub
		super.num3();
		if(chosen == 0) {
			port += "3";
		}
	}

	@Override
	public void num4() {
		// TODO Auto-generated method stub
		super.num4();
		if(chosen == 0) {
			port += "4";
		}
	}

	@Override
	public void num5() {
		// TODO Auto-generated method stub
		super.num5();
		if(chosen == 0) {
			port += "5";
		}
	}

	@Override
	public void num6() {
		// TODO Auto-generated method stub
		super.num6();
		if(chosen == 0) {
			port += "6";
		}
	}

	@Override
	public void num7() {
		// TODO Auto-generated method stub
		super.num7();
		if(chosen == 0) {
			port += "7";
		}
	}

	@Override
	public void num8() {
		// TODO Auto-generated method stub
		super.num8();
		if(chosen == 0) {
			port += "8";
		}
	}

	@Override
	public void num9() {
		// TODO Auto-generated method stub
		super.num9();
		if(chosen == 0) {
			port += "9";
		}
	}

}